SET FOREIGN_KEY_CHECKS = 0;
use dbclinica;
select ca.idcaja,ca.idpaciente,p.historia_clinica,p.tipo_documento,
		p.numero_documento,p.nombres,p.apellido_paterno,p.apellido_materno,
        ca.idconsultorio,c.idasistencial,a.nombre,
        a.apellidos,a.colegiatura,a.num_colegiatura,
        c.nombre_consultorio,numero_consultorio,
        piso_consultorio,ca.trabajador,
        ca.costo_consulta,ca.fecha_registro
from tap_caja ca 
left join tap_consultorio c on ca.idconsultorio=c.idconsultorio 
left join tap_asistenciales a on c.idasistencial=a.idasistenciales
left join tap_paciente p on ca.idpaciente=p.idpaciente;

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

select c.idconsumo,c.idcaja,c.idfarmacia,f.nombre,c.cantidad,f.precio_venta
,c.estado,c.fecha_registro from tap_consumo c 
inner join tap_farmacia f on c.idfarmacia=f.idfarmacia;


select * from tap_consultorio;


select * from tap_trabajador;
select * from tap_asistenciales;
select * from tap_paciente;
select * from tap_pago;
select * from tap_caja;
select * from tap_farmacia;
select * from tap_consumo;
select * from tap_trabajador;

SELECT
     tap_asistenciales.`idasistenciales` AS tap_asistenciales_idasistenciales,
     tap_asistenciales.`nombre` AS tap_asistenciales_nombre,
     tap_asistenciales.`apellidos` AS tap_asistenciales_apellidos,
     tap_asistenciales.`cargo_institucion` AS tap_asistenciales_cargo_institucion,
     tap_asistenciales.`modalidad_contrato` AS tap_asistenciales_modalidad_contrato,
     tap_asistenciales.`colegiatura` AS tap_asistenciales_colegiatura,
     tap_asistenciales.`num_colegiatura` AS tap_asistenciales_num_colegiatura,
     tap_asistenciales.`profesion` AS tap_asistenciales_profesion,
     tap_asistenciales.`tipo_documento` AS tap_asistenciales_tipo_documento,
     tap_asistenciales.`num_documento` AS tap_asistenciales_num_documento,
     tap_asistenciales.`celular` AS tap_asistenciales_celular,
     tap_asistenciales.`email` AS tap_asistenciales_email,
     tap_asistenciales.`fecha_registro` AS tap_asistenciales_fecha_registro
FROM
     `tap_asistenciales` tap_asistenciales
delete from tap_caja where idcaja=1;
Update tap_farmacia set stock=? where idfarmacia=1;

select p.idpago,a.nombre,a.apellidos,a.colegiatura,
	   a.num_colegiatura,a.profesion,a.tipo_documento,a.num_documento,con.nombre_consultorio,
	   con.numero_consultorio,con.piso_consultorio,c.idpaciente,paciente.historia_clinica,
       paciente.tipo_documento,paciente.numero_documento,paciente.nombres,paciente.apellido_paterno,paciente.apellido_materno,c.costo_consulta,
	   p.tipo_comprobante,p.num_comprobante,p.igv,p.cantidad_pago,
       p.subtotal,p.total,p.vuelto,p.fecha_registro,p.hora,p.trabajador
from tap_pago p 
inner join tap_caja c 
on p.idcaja=c.idcaja
inner join tap_consultorio con
on c.idconsultorio=con.idconsultorio
inner join tap_asistenciales a
on con.idasistencial=a.idasistenciales
inner join tap_paciente paciente
on c.idpaciente=paciente.idpaciente
where idpago=18;
