
-- -----------------------------------------------------
-- Table BaseDatos.persona
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS persona (
  id uuid NOT NULL,
  nombre VARCHAR(100) NOT NULL,
  genero VARCHAR(45) NOT NULL,
  edad INT NOT NULL,
  identificacion VARCHAR(45) NOT NULL,
  direccion TEXT NOT NULL,
  telefono VARCHAR(45) NOT NULL,
  CONSTRAINT pk_persona PRIMARY KEY (id));


-- -----------------------------------------------------
-- Table BaseDatos.cliente
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS cliente (
  id uuid NOT NULL,
  contrasenna TEXT NOT NULL,
  estado boolean NOT NULL DEFAULT true,
  persona_id uuid NOT NULL,
  CONSTRAINT pk_cliente PRIMARY KEY (id),
  CONSTRAINT fk1_persona FOREIGN KEY (persona_id)
  REFERENCES public.persona (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION);


-- -----------------------------------------------------
-- Table BaseDatos.cuenta
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS cuenta (
  id uuid NOT NULL,
  numero INT NOT NULL,
  tipo VARCHAR(45) NOT NULL,
  saldo double precision NOT NULL DEFAULT 0.0,
  estado boolean NOT NULL DEFAULT true,
  cliente_id uuid NOT NULL,
  CONSTRAINT pk_cuenta PRIMARY KEY (id),
  CONSTRAINT fk1_cliente FOREIGN KEY (cliente_id)
  REFERENCES public.cliente (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION);


-- -----------------------------------------------------
-- Table BaseDatos.movimiento
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS movimiento (
  id uuid NOT NULL,
  fecha timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
  tipo VARCHAR(45) NOT NULL,
  valor double precision NOT NULL,
  saldo double precision NOT NULL,
  cuenta_id uuid NOT NULL,
  CONSTRAINT pk_movimiento PRIMARY KEY (id),
  CONSTRAINT fk1_cuenta FOREIGN KEY (cuenta_id)
  REFERENCES public.cuenta (id) MATCH SIMPLE
    ON UPDATE CASCADE
    ON DELETE NO ACTION);
