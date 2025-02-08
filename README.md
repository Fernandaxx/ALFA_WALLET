# ALFA WALLET

ALFA WALLET es una aplicación intuitiva y fácil de usar que permite la compra de criptomonedas con moneda fiduciaria. Se generan datos fijos al iniciar la aplicacion para facilitar la prueba de la billetera.

## Funcionalidades Principales
- Compra de criptomonedas (BTC, USDT, DOGE, USDC) utilizando moneda fiduciaria (ARS, USD).
- Exportación de un archivo CSV con los activos del usuario.
- Visualización de un listado de transacciones realizadas.

## Implementación
Esta implementada en Java Swing siguiendo el patron MVC. Para el desarrollo del Login, SignUp y menú, se utilizó como referencia de vista el canal [LaingRaven](https://www.youtube.com/@LaingRaven).


## Origen del Nombre
El nombre **AlfaWallet** surge de las siglas de sus creadoras: **Acuña Lucía y Fernanda Avila.**




## Cambios Realizados para le Re-Entrega

### **Compra**
- Se actualiza la cantidad de criptomoneda a recibir al ingresar un monto en moneda fiduciaria.
- Se informa en pantalla el estado de la compra.
- Al realizar una compra, ahora se actualiza el stock disponible en la vista, no solo en la base de datos.

### **Cotizaciones**
- Se cargan los precios de las criptomonedas al abrir la vista.
- La vista solo se actualiza si la API responde correctamente.
- Se eliminó el mensaje de error relacionado con la API (Error 429).

### **Mejoras en la Vista**
- Se agregó un botón de cierre en la pantalla de login.

### **Manejo de Excepciones**
- Se corrigieron las excepciones al tipo adecuado.
- **Login:** Manejo de errores como contraseña incorrecta o usuario no registrado.
- **SignUp:** Validaciones para campos incompletos, términos y condiciones no aceptados, y usuario ya existente.
- **Compra:** Verificación de fondos fiat insuficientes y stock insuficiente.

### **Exportación CSV**
- Si el usuario no posee activos, no se genera el archivo CSV.
- Se muestra un mensaje informando sobre la situación.

---

