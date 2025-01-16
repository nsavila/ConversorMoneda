# Conversor de Monedas

Este proyecto es un Conversor de Monedas implementado en **Java 17**, que permite realizar conversiones entre cuatro monedas específicas:
- Dólar (USD)
- Peso Colombiano (COP)
- Peso Argentino (ARS)
- Real Brasileño (BRL)  

## Características
- Conversión en tiempo real: Utiliza la API de ExchangeRate-API para obtener tasas de cambio actualizadas.
- Interfaz interactiva: Menú basado en línea de comandos (CLI) para facilitar el uso.
- Modularidad: Separación del manejo de API (ConsumoApi), modelos (Moneda) y lógica principal (Main).
- Gestión robusta de errores: Maneja errores como tasas no disponibles o entrada de usuario no válida.

## Requisitos
- Java 17 o superior.
- IntelliJ IDEA u otro IDE de tu preferencia.
- API Key de ExchangeRate-API.
- Gson 2.11.0

## Instrucciones de Uso

### Configura la clave API:
1. Reemplaza 5e421e3bc7ba7d6bc46dbc8d en la URL de la API en la clase ConsumoApi con tu propia clave API.

### Compila el proyecto con el siguiente comando:
2. javac -cp ./libs/gson-2.11.0.jar -d out src/*.java

### Ejecuta el proyecto con el siguiente comando:
3. java -cp ./libs/gson-2.11.0.jar:./out Main

### Interacción: 
4. -Sigue las instrucciones del menú para convertir entre monedas.
   -Ingresa valores y recibe resultados en tiempo real.

## Contribuciones
¡Las contribuciones son bienvenidas! Si tienes ideas o mejoras, por favor abre un pull request o una issue.
