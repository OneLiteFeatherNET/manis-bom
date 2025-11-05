## Manis Source BOM

The project acts as the central source BOM of the Manis project.  
It combines dependency version management with common source code used by multiple modules. This separation improves
maintainability and simplifies updates to shared dependencies and code.

## Dependency Management

This project is automatically maintained by Renovate.
Renovate keeps all dependency versions in this BOM up to date, ensuring consistent and secure versions across the Manis ecosystem.
Manual version changes are usually not required only when.

> [!NOTE]
> Adding or removing dependencies in this BOM must be done manually.  
> Renovate will only update existing versions.