/*-----------------------------------------------------
CODIGO PARA REALIZAR OPERACIONES DE DELETE REGISTRO
-----------------------------------------------------*/
SET FOREIGN_KEY_CHECKS = 0;

/*-----------------------------------------------------
UTILIZAR LA DB
-----------------------------------------------------*/
use dbclinica;
/*-----------------------------------------------------
REPORTE DE CAJA - CLIENTES
-----------------------------------------------------*/
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
/*-----------------------------------------------------
FUNCION SUMAR STOCK  - TABLA FARMACIA
-----------------------------------------------------*/
SELECT * FROM dbclinica.tap_farmacia;
select sum(stock) from dbclinica.tap_farmacia;
select (precio_venta*stock) as SubTotal from dbclinica.tap_farmacia;

/*-----------------------------------------------------
FORMATO FECHA DE LA TABLA FARMACIA
-----------------------------------------------------*/
select idfarmacia,categoria,nombre,precio_venta,stock,laboratorio,presentacion,fecha_registro,DATE_FORMAT(STR_TO_DATE(REPLACE(fecha_registro,'-','.'),
GET_FORMAT(date,'EUR')),"%d-%m-%Y"),DATE_FORMAT(fecha_vencimiento, "%d-%m-%Y"),fecha_vencimiento
from dbclinica.tap_farmacia;
use dbclinica;
SELECT idfarmacia,categoria,
                nombre,precio_venta,stock,
                laboratorio,presentacion,
                DATE_FORMAT(STR_TO_DATE(REPLACE(fecha_registro,'-','.'),GET_FORMAT(date,'EUR')),"%d-%m-%Y") as fecha_registroo,
                fecha_registro,str_to_date(fecha_registro,"%d-%m-%Y"),
                DATE_FORMAT(fecha_vencimiento, "%d-%m-%Y") as fecha_vencimiento FROM tap_farmacia
                where str_to_date(fecha_registro,"%d-%m-%Y") between '2020-08-23' and '2020-09-27';

SELECT * FROM dbclinica.tap_farmacia;
select sum(stock) from dbclinica.tap_farmacia;
select (precio_venta*stock) as SubTotal from dbclinica.tap_farmacia;

select c.idconsumo,c.idcaja,c.idfarmacia,f.nombre,c.cantidad,f.precio_venta
,c.estado,c.fecha_registro from tap_consumo c 
inner join tap_farmacia f on c.idfarmacia=f.idfarmacia;

/*-----------------------------------------------------
SELECT DE LAS TABLAS
-----------------------------------------------------*/
select * from tap_consultorio;
select * from tap_trabajador;
select * from tap_asistenciales;
select * from tap_paciente;
select * from tap_pago;
select * from tap_caja;
select * from tap_farmacia;
select * from tap_consumo;
select * from tap_trabajador;
select * from tap_certificadosalud;

/*-----------------------------------------------------
REPORTE DE PAGO CON IDPAGO- TABLA PAGO
-----------------------------------------------------*/
select p.idpago,a.nombre,a.apellidos,a.colegiatura,
	   a.num_colegiatura,a.profesion,a.tipo_documento,a.num_documento,con.nombre_consultorio,
	   con.numero_consultorio,con.piso_consultorio,c.idpaciente,paciente.historia_clinica,
       paciente.tipo_documento,paciente.numero_documento,paciente.nombres,paciente.apellido_paterno,paciente.apellido_materno,CONCAT('S/.',FORMAT(c.costo_consulta,2)) costo_consulta,
	   p.tipo_comprobante,p.num_comprobante,CONCAT('S./',FORMAT(p.igv,2)) igv,CONCAT('S./',FORMAT(p.cantidad_pago,2)) cantidad_pago,
       CONCAT('S/.',FORMAT(p.subtotal,2)) subtotal,CONCAT('S/.',FORMAT(p.total,2)) total,CONCAT('S/.',FORMAT(p.vuelto,2)) vuelto,p.fecha_registro,p.hora,p.trabajador
from tap_pago p 
inner join tap_caja c 
on p.idcaja=c.idcaja
inner join tap_consultorio con
on c.idconsultorio=con.idconsultorio
inner join tap_asistenciales a
on con.idasistencial=a.idasistenciales
inner join tap_paciente paciente
on c.idpaciente=paciente.idpaciente
where idpago=19;
/*-----------------------------------------------------
REPORTE DE PAGO CON IDCAJA- TABLA PAGO 
-----------------------------------------------------*/
select c.idcaja,p.idpago,a.nombre,a.apellidos,a.colegiatura,
	   a.num_colegiatura,a.profesion,a.tipo_documento,a.num_documento,con.nombre_consultorio,
	   con.numero_consultorio,con.piso_consultorio,c.idpaciente,paciente.historia_clinica,
       paciente.tipo_documento,paciente.numero_documento,paciente.nombres,paciente.apellido_paterno,paciente.apellido_materno,CONCAT('S/.',FORMAT(c.costo_consulta,2)) costo_consulta,
	   p.tipo_comprobante,p.num_comprobante,CONCAT('S./',FORMAT(p.igv,2)) igv,CONCAT('S./',FORMAT(p.cantidad_pago,2)) cantidad_pago,
       CONCAT('S/.',FORMAT(p.subtotal,2)) subtotal,CONCAT('S/.',FORMAT(p.total,2)) total,CONCAT('S/.',FORMAT(p.vuelto,2)) vuelto,c.fecha_registro,p.hora,p.trabajador
from tap_caja c 
left join tap_pago p 
on c.idcaja=p.idcaja
left join tap_consultorio con
on c.idconsultorio=con.idconsultorio
left join tap_asistenciales a
on con.idasistencial=a.idasistenciales
left join tap_paciente paciente
on c.idpaciente=paciente.idpaciente
where DATE_FORMAT( STR_TO_DATE( c.fecha_registro , "%d-%m-%Y" ) , "%d-%m-%Y" ) between '28-08-2020' and '13-09-2020';

select idpago,idcaja,sum(total) from tap_pago;
select * from tap_paciente where STR_TO_DATE(fecha_registro , "%d-%m-%Y" ) between '2020-08-30' and '2020-08-30';


select c.idcertificado_salud,c.idasistenciales,CONCAT(a.nombre," ",a.apellidos) as datosAsistencial,a.colegiatura,a.num_colegiatura,c.idpaciente,p.historia_clinica,p.tipo_documento,
p.numero_documento,CONCAT(p.nombres," ",p.apellido_paterno," ",p.apellido_materno) as datosPaciente,p.edad,p.direccion,c.serelogia,c.examen_rx,c.hemoglobina,
c.fecha_registro 
from tap_certificadosalud c 
inner join tap_asistenciales a 
on c.idasistenciales=a.idasistenciales 
inner join tap_paciente p 
on c.idpaciente=p.idpaciente where STR_TO_DATE(c.fecha_registro, "%d-%m-%Y" ) between '2020-09-16' and '2020-10-17';



select c.idinforme_medico,c.idasistenciales,a.nombre,a.apellidos,a.colegiatura,a.num_colegiatura,c.idpaciente,p.historia_clinica,p.tipo_documento,
		p.numero_documento,p.nombres,p.apellido_paterno,p.apellido_materno,p.edad,p.direccion,c.diagnostico,c.dias_descanso,c.fecha_registro,c.fecha_system
from tap_informemedico c 
     inner join tap_asistenciales a on c.idasistenciales=a.idasistenciales 
     inner join tap_paciente p on c.idpaciente=p.idpaciente 
 where str_to_date(c.fecha_system, "%d-%m-%Y") between '2020-09-16' and '2020-10-17';
 
 select * from tap_informemedico;
 
 select idasistenciales,nombre,apellidos,
                cargo_institucion,modalidad_contrato,
                colegiatura,num_colegiatura,
                profesion,tipo_documento,
                num_documento,celular,email,
fecha_registro,fecha_system from tap_asistenciales 
where str_to_date(c.fecha_system,"%d-%m-%Y") between '2020-09-16' and '2020-10-17';
 
SELECT * FROM dbclinica.tap_trabajador
where str_to_date(fecha_registro,"%d-%m-%Y") between '2020-08-15' and '2020-08-24';


select c.idconsultorio,c.idasistencial,a.nombre,a.apellidos,a.colegiatura,a.num_colegiatura,
c.nombre_consultorio,c.numero_consultorio,c.piso_consultorio,c.fecha_registro 
from tap_consultorio c 
inner join tap_asistenciales a on c.idasistencial=a.idasistenciales
where str_to_date(c.fecha_registro, "%d-%m-%Y") between '2020-08-23' and '2020-08-23';
