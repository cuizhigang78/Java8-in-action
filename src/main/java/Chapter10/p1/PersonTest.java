package Chapter10.p1;

/**
 * @ClassName PersonTest
 * @Author cuizhigang
 * @Date 2020/8/14 11:21
 * @Description PersonTest
 * @Version 1.0
 */
public class PersonTest {
    public static void main(String[] args) {
        PersonTest test = new PersonTest();
        test.getCarInsuranceNam0(new Person());
    }

    public String getCarInsuranceNam0(Person person) {
        return person.getCar().getInsurance().getName();
    }

    public String getCarInsuranceName1(Person person) {
        if (person != null) {
            Car car = person.getCar();
            if (car != null) {
                Insurance insurance = car.getInsurance();
                if (insurance != null) {
                    return insurance.getName();
                }
            }
        }
        return "Unknown";
    }

    public String getCarInsuranceName2(Person person) {
        if (person == null) {
            return "Unknown";
        }
        Car car = person.getCar();
        if (car == null) {
            return "Unknown";
        }
        Insurance insurance = car.getInsurance();
        if (insurance == null) {
            return "Unknown";
        }
        return insurance.getName();
    }
}
