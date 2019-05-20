#ASM
#### Administrado de Talleres

Sistema confiable, fácil de usar y de implementar en talleres pequeños, medianos y grandes de México. 

Justificación:
Solo en la ciudad de méxico existen más de 4 millones de talleres mecánicos, algunos genéricos y otros que se especializan en ciertas marcas y reparaciones. Actualmente no hay un sistema el cual beneficie al administrador del taller como al cliente. Los procesos de trabajo suelen no ser tan eficiente y el cliente no conoce el estatus de su vehículo hasta que recibe una llamada del taller o hasta que recoge su vehículo, donde a veces se llevan muchas sorpresas. 


Objetivo:
Crear una multiplataforma la cual beneficie a las dos partes, es decir al taller y al cliente. 

Funcionamiento:
En el caso del taller, que se cuente con un registro de clientes fácil de accesar, historial del cliente y sus automóviles, elaboración automática de reportes al igual que la evaluación de desempeño de los empleados. Por otra parte en cuanto al cliente, que esté enterado del progreso del servicio de su vehículo en todo momento, que reciba estatutos automáticos y facilidades de pagos, facturas y recibos. 

Seguimiento: Desde que se genera la orden de servicio, todo el seguimiento de la reparación, mantenimiento, etc. De algún vehículo y la entrega tendrá Feedbacks por parte del cliente y del sistema.
Tener la escalabilidad siempre en cuenta, no importa el número de órdenes o de talleres que se tengan.


MVP:
Seguimiento: Llega un cliente con un coche, se hace una evaluación(que es lo que se va a hacer). La evaluación siempre queda abierta para poder agregar a la orden cualquier pendiente o servicio.Dentro de la evaluación también se contemplan los siguientes puntos: mecánico que se encargará del trabajo, las piezas que serán reemplazadas, problemas, soluciones y tiempo.
Features del Sistema:

Asignar vehículos a mecánicos respecto a sus trabajos previos y experiencia con marcas y/o tipo de vehículos, llevar un control de nómina y más eficiente.

Historial de cliente-vehículo: que reparaciones y servicios previos, se han hecho para dar una evaluación del vehículo. → recomendaciones

Envio de recibo automáticos
 
Clases:
Orden de Servicio
Número de Orden: ID único que representa la orden - Inicial: 0000012
Cliente: Datos del cliente (Nombre, telefono, correo,...)
Automóvil del cliente
Tipo de Servicio: Tipo de servicio que se va a aplicar al automóvil
Empleado Asignado
Observaciones: Cualquier observación que se tenga del vehículo y que sea importante para alguno proceso.
Fecha de entrada - Fecha tentativa de entrega
Precio del servicio: Precio calculado por el tipo de servicio, las piezas a utilizar, el tiempo en el taller entre otros factores.
Fecha de entrega: Fecha tentativa de entrega.
Status de la orden. (Activa, Pendiente, Cancelada, Finalizada)
Calificación del Servicio. Al finalizar la orden, el cliente califica el servicio que se le dio a su carro.
Establecer Servicio
El administrador del taller o gerente en turno puede predefinir tipos de servicios, estimando el tiempo trabajo, las piezas que se utilizan para realizar el servicio y también un costo aproximado considerando la mano de obra. 
Tipo de servicio
Nombre
Descripción
Categoría(s)
Piezas y/o material requerido
Modelo
Marca
Descripción
Precio
Tiempo estimado
Precio
Empleado
El administrador del taller es quien da de alta a los empleados.
    Registro
Id. - Inicial: E001
Información Personal
Nombre
Apellidos
Teléfono
Dirección
Fecha de Nacimiento
Perfil de trabajo
Especialidades
Puesto
Supervisor
Gerente
Mecánico
Asistente
Calificación
Historial de trabajo
Días de pago
Tipo de pago
Fijo
Comisiones
Ambos
Periodo de pago
Diario
Semanal
Quincenal
Mensual
Seguro Social
Número de seguro social
Cliente
El administrador del taller da de alta a los clientes, 
Ingresar datos personales del cliente
ID - Inicial: C000000
Nombre
Apellidos
Teléfono celular
Email
Dirección (Opcional)
Automoviles 

Automóviles
El administrador o mecánico elabora un registro del automóvil del cliente, este depende estrictamente a cada cliente. 
ID - Inicial: A0000000
Marca
Modelo
Año
Placas
Número de Serie
Historial
Servicios Previos

Sistema

Dashboard (Modular)
Servicios en operación
Piezas por compra
Balance ingresos, egresos
Trabajadores activos y en vehículo en el que trabajan

Servicios
Nueva orden de servicio
Tipos de servicio
Nuevo tipo de servicio
Clientes
Vista de todos los clientes
Barra de búsqueda
Configuración
Registrar un nuevo cliente
Registrar un Automóvil
Historial de servicios
Editar cliente
Empleados
Vista de todos los empleados activos
Barra de busqueda
Configuración
Registrar un nuevo empleado
Activar - Desactivar
Registro de tiempo
Historial de trabajo
Editar empleado
Reportes
Servicios concluidos
Piezas compradas
Ganancias 
Configuración
Taller
Nombre del taller
Encargado
Dirección
Horarios laborales
Dashboard




Distribución de Funcionalidades:
Jerarquía de Trabajo

Administrador 
Configuración general (Facturación, Nómina, etc)
    Configurar dashboard
    Dar de alta clientes
    Dar de alta automóviles
    Ver pedidos de piezas pendientes
    Generar ordenes de servicios
Gerente
    Dar de alta empleados
    Dar de alta clientes
    Dar de alta automóviles
    Ver pedidos de piezas pendientes
    Generar ordenes de servicios
Empleados
    Tipo de empleado:
Mecánico
        Visualizar todas sus órdenes de servicio
        Dar de alta clientes
        Dar de alta automóviles
        Generar ordenes de servicios
Secretaría
Dar de alta clientes
Asistentes
A quien está asignado
Casos de Uso
Orden de Servicios
El cliente llega con su coche al taller mecánico
Se hace una evaluación del vehículo, el mecánico o encargado en turno establece una conversación con el cliente para conocer la problemática del vehículo o el servicio que requiere el mismo.
El mecánico o encargado en turno ingresar la información a la aplicación
Si el cliente no existe en la base de datos, se le pide su información y la del vehículo. 
Si el cliente existe en la base de datos, la aplicación deberá ayudar al usuario a completar la información.
Se selecciona un servicio de la lista de tipos de servicio predefinidos por el administrador del Taller
Te da un estimado del precio, autopartes  y el tiempo en el que tardará .
Si todo está bien, si el cliente está de acuerdo el encargado genera la orden.
Una vez generada la orden. Se asigna un TODO al mecánico disponible o que es asignado por el encargado o administrador en turno.
El mecánico trabajará en las órdenes que tenga asignadas y en caso de encontrar otro problema en el vehículo, o si es necesario alguna otra piezas, lo ingresará al sistema para hacer el pedido para notificar al encargado en turno y así solicitar la pieza al igual que notificar al cliente. 
Una vez que acabe de dar el servicio al auto presionará un botón para finalizar la orden. Se guardará el tipo de servicio, el total de material utilizado, el tiempo, etc. Para poder dar mejores predicciones en el futuro.
Una vez completado el servicio se le notificará al cliente que su vehículo está listo y que puede venir a recogerlo cuando quiera. El cliente podrá también ver el estado de la orden de servicio. Le llegará a su 
De Acuerdo al tiempo que tiene restante el mecanico se le propondrán tareas que hacer.
Orden de servicio
Nómina(Debe de ser un módulo externo, sólo debe de recibir unos cuantos más datos pero debe de funcionar por su cuenta.):

Tenemos un historial del seguimiento de los trabajos que ha hecho el mecánico, también que tanto revenue nos a dejado por cada uno de los trabajos (No es lo mismo dar algún servicio a un Audi que a un Sedan)

Notifiación a clientes(IMPORTANTE, DEBE DE IR EN EL MVP)

Interacción entre el taller y el cliente.
Seguimiento lo más general posible. No necesitamos los detalles, el desarrollo será de lo general a lo específico.    

Identificar Actores: Gerente, mecánico, cliente

¿Qué es lo que al Mecánico le interesa del proceso?
Saber qué es lo que va a hacer
¿Qué es lo que al Cliente le interesa del proceso?
Como va su orden
Si ha habido algún inconveniente
Si ya puede ir a recoger su carro
¿Qué es lo que al Gerente le interesa del proceso?
Si está ganando lo justo por operaciones.
Por que operaciones está ganando más dinero
Cuales de sus empleados le producen más dinero (Tal vez no pueda verse reflejado, propenso a ser quitado)
Saber los pedidos que se tienen pendientes.
Saber si las fechas de entrega está a tiempo o hay retrasos.
Saber quienes son los encargados de las reparaciones.

Objetivo principal: Ganar más dinero o perder menos dinero
Como se puede ganar más dinero: Consiguiendo clientes, optimizando procesos, reduciendo pérdidas.

Preguntar: ¿Qué es lo que más genera perdidas a un taller?


Future IDEAS:
Control de asistencia
Feedback del cliente y seguimiento del vehículo en tiempo real.
Generar citas para servicios
Inventario (No es necesario para el MVP):
Se tendrá un inventario de las piezas, precios de proveedor, precios de venta.
También se llevará un historial de los materiales más utilizados y más vendidos para decisiones de negocio.
En el Inventario se tiene todas las autopartes, herramientas, etc.


Cliente
Los clientes generan su solicitud de creación y una vez que vengan al taller serán creados. Por qué no pueden crearse ellos solos ?
Los clientes pueden crear su cuenta, pero tienen que ser validados por el administrador del taller

