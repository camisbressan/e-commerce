CREATE TABLE `Produto` (
);

CREATE TABLE `TB_Produto` (
`pk_Produto` int NOT NULL,
`nomeProduto` varchar(255) NOT NULL,
`quantidadeProduto` int NOT NULL,
`codigoProduto` int NOT NULL,
`valorProduto` decimal(10,2) NOT NULL,
PRIMARY KEY (`pk_Produto`) 
);

CREATE TABLE `TB_Pedido` (
`pk_Pedido` int NOT NULL,
`fk_EnderecoCliente` int NOT NULL,
PRIMARY KEY (`pk_Pedido`) 
);

CREATE TABLE `TB_EnderecoCliente` (
`pk_EnderecoCliente` int NOT NULL,
`fk_Cliente` int NOT NULL,
`tipoLogradouro` varchar(255) NOT NULL,
`endereco` varchar(255) NOT NULL,
`numero` varchar(255) NOT NULL,
`complemento` varchar(255) NOT NULL,
`bairro` varchar(255) NOT NULL,
`cidade` varchar(255) NOT NULL,
`uf` varchar(255) NOT NULL,
`pais` varchar(255) NOT NULL,
`cep` varchar(255) NOT NULL,
PRIMARY KEY (`pk_EnderecoCliente`) 
);

CREATE TABLE `TB_ItemPedido` (
`pk_itemPedido` int NOT NULL,
`fk_Produto` int NOT NULL,
`fk_Pedido` int NOT NULL,
PRIMARY KEY (`pk_itemPedido`) 
);

CREATE TABLE `TB_Cliente` (
`pk_Cliente` int NOT NULL,
`primeiroNome` varchar(50) NOT NULL,
`sobreNome` varchar(255) NOT NULL,
`dataNadcimento` date NOT NULL,
`cpf` varchar(255) NULL,
`rg` varchar(255) NULL,
PRIMARY KEY (`pk_Cliente`) 
);


ALTER TABLE `TB_Produto` ADD CONSTRAINT `fk_TB_Produto_TB_ItemPedido_1` FOREIGN KEY (`pk_Produto`) REFERENCES `TB_ItemPedido` (`fk_Produto`);
ALTER TABLE `TB_Pedido` ADD CONSTRAINT `fk_TB_Pedido_TB_ItemPedido_1` FOREIGN KEY (`pk_Pedido`) REFERENCES `TB_ItemPedido` (`fk_Pedido`);
ALTER TABLE `TB_Cliente` ADD CONSTRAINT `fk_TB_Cliente_TB_EnderecoCliente_1` FOREIGN KEY (`pk_Cliente`) REFERENCES `TB_EnderecoCliente` (`fk_Cliente`);
ALTER TABLE `TB_EnderecoCliente` ADD CONSTRAINT `fk_TB_EnderecoCliente_TB_Pedido_1` FOREIGN KEY (`pk_EnderecoCliente`) REFERENCES `TB_Pedido` (`fk_EnderecoCliente`);

