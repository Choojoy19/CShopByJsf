package sc.task.cshop.controller;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItem;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.util.Collection;
import java.util.stream.Stream;

@FacesConverter("ListConverter")
public class ListConverter implements Converter {

    public static interface IdObject {
        public String getDisplayId();
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }

        return component.getChildren().stream()
                .flatMap(child -> getEntriesOfItem(child))
                .filter(o -> value.equals(o instanceof IdObject ? ((IdObject) o).getDisplayId() : o))
                .findAny().orElse(null);
    }

    /**
     * Gets the values stored in a {@link UISelectItem} or a {@link UISelectItems}.
     * For other components returns an empty stream.
     */
    private Stream<?> getEntriesOfItem(UIComponent child) {
        if (child instanceof UISelectItem) {
            UISelectItem item = (UISelectItem) child;
            if (!item.isNoSelectionOption()) {
                return Stream.of(item.getValue());
            }

        } else if (child instanceof UISelectItems) {
            Object value = ((UISelectItems) child).getValue();

            if (value instanceof Collection) {
                return ((Collection<?>) value).stream();
            } else {
                throw new IllegalStateException("Unsupported value of UISelectItems: " + value);
            }
        }

        return Stream.empty();
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) return null;
        if (value instanceof String) return (String) value;
        if (value instanceof IdObject) return ((IdObject) value).getDisplayId();

        throw new IllegalArgumentException("Unexpected value type");
    }

}