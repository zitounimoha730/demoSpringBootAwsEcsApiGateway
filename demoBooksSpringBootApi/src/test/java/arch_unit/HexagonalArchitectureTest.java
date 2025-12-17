package arch_unit;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.jmolecules.archunit.JMoleculesArchitectureRules;

import static arch_unit.HexagonalArchitectureTest.APP_ROOT_PACKAGE;

@AnalyzeClasses(packages = APP_ROOT_PACKAGE, importOptions = ImportOption.DoNotIncludeTests.class)
class HexagonalArchitectureTest extends ArchUnitCustoms {

    @ArchTest
    @SuppressWarnings("unused")
    public static final ArchRule Hexagonal_principle_test = JMoleculesArchitectureRules.ensureHexagonal();

    @ArchTest
    @SuppressWarnings("unused")
    public static final ArchRule No_class_of_domain_should_depends_on_infrastructure = ArchRuleDefinition.noClasses().that()
            .resideInAPackage(DOMAIN_ROOT)
            .should()
            .dependOnClassesThat()
            .resideInAPackage(INFRASTRUCTURE_ROOT);


    @ArchTest
    @SuppressWarnings("unused")
    public static final ArchRule No_class_of_domain_should_depends_on_application = ArchRuleDefinition.noClasses().that()
            .resideInAPackage(DOMAIN_ROOT)
            .should()
            .dependOnClassesThat()
            .resideInAPackage(APPLICATION_ROOT)
            .as("No class of domain should have dependency from application")
            .because("Doamin have to be totaly independant");

    @ArchTest
    @SuppressWarnings("unused")
    public static final ArchRule Each_feature_should_have_ports_package = ArchRuleDefinition.classes().that()
            .resideInAPackage(PORT_PACKAGE)
            .should()
            .beInterfaces();


}
