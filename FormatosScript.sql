SET FOREIGN_KEY_CHECKS = 0;
use dbclinica;
select ca.idcaja,ca.idconsultorio,c.idasistencial,a.nombre,a.apellidos,a.colegiatura,a.num_colegiatura,c.nombre_consultorio,numero_consultorio,piso_consultorio,ca.trabajador,ca.costo_consulta,ca.fecha_registro
from tap_caja ca left join tap_consultorio c on ca.idconsultorio=c.idconsultorio left join tap_asistenciales a on c.idasistencial=a.idasistenciales;

SELECT * FROM dbclinica.tap_farmacia;
select sum(stock) from dbclinica.tap_farmacia;
select (precio_venta*stock) as SubTotal from dbclinica.tap_farmacia;

/*FORMATO FECHA DE LA TABLA FARMACIA*/
select idfarmacia,categoria,nombre,precio_venta,stock,laboratorio,presentacion,fecha_registro,DATE_FORMAT(STR_TO_DATE(REPLACE(fecha_registro,'-','.'),
GET_FORMAT(date,'EUR')),"%d-%m-%Y"),DATE_FORMAT(fecha_vencimiento, "%d-%m-%Y"),fecha_vencimiento
from dbclinica.tap_farmacia;

SELECT * FROM dbclinica.tap_farmacia;
select sum(stock) from dbclinica.tap_farmacia;
select (precio_venta*stock) as SubTotal from dbclinica.tap_farmacia;


select * from tap_consultorio;
select * from tap_caja;
select * from tap_trabajador;
select * from tap_asistenciales;