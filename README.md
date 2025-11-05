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


## Included BOMs

This BOM definition relies on other BOMs to simplify version and dependency management.
The following BOMs are included:

- [Mycelium-BOM](https://github.com/OneLiteFeatherNET/Mycelium-bom)
- [Aonyx-BOM](https://github.com/OneLiteFeatherNET/Aonyx-bom)
- [Cloudnet-BOM](https://github.com/CloudNetService/CloudNet/tree/nightly/bom)
- [Hibernate-ORM-BOM](https://mvnrepository.com/artifact/org.hibernate.orm/hibernate-platform)