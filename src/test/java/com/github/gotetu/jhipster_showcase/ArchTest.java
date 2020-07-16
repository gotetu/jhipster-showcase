package com.github.gotetu.jhipster_showcase;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {

        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.github.gotetu.jhipster_showcase");

        noClasses()
            .that()
                .resideInAnyPackage("com.github.gotetu.jhipster_showcase.service..")
            .or()
                .resideInAnyPackage("com.github.gotetu.jhipster_showcase.repository..")
            .should().dependOnClassesThat()
                .resideInAnyPackage("..com.github.gotetu.jhipster_showcase.web..")
        .because("Services and repositories should not depend on web layer")
        .check(importedClasses);
    }
}
