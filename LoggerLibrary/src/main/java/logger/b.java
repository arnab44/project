package logger;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Builder
public abstract class IValidation {
    public Designation designation;
    private IValidation subValidationCriteria;
    private
    IValidation(IValidation subValidationCriteria){
        this.subValidationCriteria = subValidationCriteria;
    }
    public abstract boolean validate(Employee emp, boolean isAndSubcriteria);

}

public class DepartmentValidation implements IValidation {
    public Department department;
    DepartmentValidation(Department department, IValidation subValidationCriteria){
        this.department = department;
        super(subValidationCriteria);
    }
    @Override
    public boolean validate(Employee emp, boolean isAndSubcriteria) {
        boolean baseValidation = (emp.department == this.department)

        if(isAndSubcriteria){
            return baseValidation &&   subValidationCriteria.validate(emp);
        }
        return baseValidation || subValidationCriteria.validate(emp);
    }
}



@Builder
public class YearValidation implements IValidation {
    public int minExp;
    public int maxExp;

    YearValidation(int minExp, int maxExp, IValidation subValidationCriteria) {
        this.minExp = minExp;
        this.maxExp = maxExp;
        super(subValidationCriteria);
    }

    public boolean validate(Employee emp) {
        boolean baseValidation = emp.yearsOfExperience >= minExp && emp.yearsOfExperience < maxExp)

        if(isAndSubcriteria){
            return baseValidation &&   subValidationCriteria.validate(emp);
        }
        return baseValidation || subValidationCriteria.validate(emp);
    }   subValidationCriteria.validate(emp);
    }
}

@Builder
public class QualificationValidation implements IValidation {
    public Degree qualification;
    public IValidation subValidationCriteria;

    QualificationValidation(Degree qualification, IValidation subValidationCriteria) {
        this.qualification = qualification;
        this.subValidationCriteria = subValidationCriteria;
    }

    public boolean validate(Employee emp) {
        return  (emp.qualification == this.qualification)
                && subValidationCriteria.validate(emp);
    }
}

public class DesignationFactory {

    public static List<IValidation> getAllDesignationCriteria() {
        List<IValidation> criterias = new ArrayList<>();

        IValidation assiantSalesAssociate = new DepartmentValidation(Department.SALES,
                new YearValidation(0, 5,
                        new QualificationValidation( Degree.HIGH_SCHOOL)));
        assiantSalesAssociate.designation = Designation.ASSISTANT_SALES_ASSOCIATE;

        criterias.add(assiantSalesAssociate);

        IValidation salesAssociate1 = new DepartmentValidation(Department.SALES,
                new YearValidation(0, 5,
                        new QualificationValidation(Degree.BBA)));

        salesAssociate1.designation = Designation.SALES_ASSOCIATE;
        criterias.add(salesAssociate1);

        IValidation  salesAssociate2 = new DepartmentValidation(Department.SALES,
                new YearValidation(5, 10,
                    new QualificationValidation(Degree.HIGH_SCHOOL)));
        salesAssociate2.designation = Designation.SALES_ASSOCIATE;
        criterias.add(salesAssociate2);


       // Similarly we can create criteria objects other designations

        return  criterias;
    }
}


public Designation getDesignation(Employee emp) {

    List<IValidation> criterias = DesignationFactory.getAllDesignationCriteria();
    for(IValidation criteria : criterias) {
        if(criteria.validate(emp))
            return criteria.designation;
    }

}


public class DepartmentValidation implements IValidation {
    public Department department;
    DepartmentValidation(Department department, IValidation subValidationCriteria){
        this.department = department;
        super(subValidationCriteria);
    }
    @Override
    public boolean validate(Employee emp, boolean isAndSubcriteria) {
        boolean baseValidation = (emp.department == this.department)

        if(isAndSubcriteria){
            return baseValidation &&   subValidationCriteria.validate(emp);
        }
        return baseValidation || subValidationCriteria.validate(emp);
    }
}