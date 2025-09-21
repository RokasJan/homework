# Homework SOAP Service


This is a **Spring Boot SOAP service** demo application that uses **JAXB** for XML binding and **XSD schema validation**.  

The service exposes operations for managing services and customers via SOAP requests.

For localhost, WSDL is accessable by url - http://localhost:8080/ws/service.wsdl.

---

### Notes

For VS Code Java language server issue:

1. **Make sure the generated sources are marked as source folder:**
   - Open <code>.vscode/settings.json</code> or the Java project settings.
   - Add <code>target/generated-sources/jaxb</code> as a source folder.

2. **Refresh the project in VS Code**
   - Press `Ctrl+Shift+P` (Cmd+Shift+P on macOS)
   - Run `Java: Clean the Java language server workspace`
   - Restart VS Code when prompted.

3. **Rebuild the project**
   - Run `mvn clean install` (or `gradlew clean build`) to regenerate the `target` folder.
   - Sometimes VS Code needs a fresh build to pick up generated sources or updated classes.
