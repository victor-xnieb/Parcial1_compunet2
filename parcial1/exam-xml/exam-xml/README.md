# Examen IoT — Variante 2: DI por XML (beans.xml)

## Wiring
`WEB-INF/beans.xml` declara cada bean a mano (`deviceRepository`,
`measurementRepository`, `ioTService`) y conecta las dependencias del service
con `<constructor-arg ref="...">`. Las clases Java son POJOs normales, sin
ninguna anotación de Spring.

`web.xml` NO sobreescribe `contextClass`, así que `ContextLoaderListener` usa
por defecto `XmlWebApplicationContext`, apuntando a `/WEB-INF/beans.xml`.

## Compilar y desplegar
```bash
mvn clean package
# copia target/examen-iot-xml.war a $CATALINA_HOME/webapps/
```
O en IntelliJ: configura un "Tomcat Server" run config con este módulo como
artifact (war exploded), Deployment Application context: `/examen-iot-xml`.

## Probar
- `GET /add-form` → formulario HTML para registrar una medición.
- `POST /add-measurement` (params: `assetId`, `timestamp`, `valor`).
- `GET /list-measurements` → tabla HTML con todas las mediciones.

Dispositivo semilla: id=1, rango [-100, 300], samplingPeriod=2000ms, tolerancia=200ms.
Mediciones semilla: timestamp=2000 y 4000.

Ejemplos para probar las reglas de negocio:
- Válida: assetId=1, timestamp=6000, valor=27 (diff=2000, dentro de tolerancia)
- Fuera de rango: assetId=1, timestamp=6000, valor=999
- Timestamp duplicado: assetId=1, timestamp=2000, valor=25
- Intervalo inválido: assetId=1, timestamp=6500, valor=27 (diff=2500, fuera de 1800-2200)
