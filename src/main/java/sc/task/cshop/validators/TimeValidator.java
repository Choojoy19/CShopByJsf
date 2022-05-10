package sc.task.cshop.validators;



import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import java.time.LocalTime;

public class TimeValidator {
    public void validateTime(FacesContext context,
                             UIComponent toValidate, Object value1, Object value2) throws ValidatorException {
        LocalTime fromTime = (LocalTime) value1;
        LocalTime toTime = (LocalTime) value2;
        if (fromTime.compareTo(toTime)>=0) {
            FacesMessage message = new FacesMessage("fromTime can not be greater");
            throw new ValidatorException(message);
        }
    }
}