SELECT cn.id, cl.identificacion, cn.tipo, cn.saldo
FROM cuentas cn
JOIN clientes cl ON cl.id = cn.id_cliente
WHERE cl.identificacion = 123456789 AND cn.saldo >= 100000;
