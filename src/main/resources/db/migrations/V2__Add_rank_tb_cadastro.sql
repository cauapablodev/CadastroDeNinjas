-- V2: Migrations para adicionar a tabela rank_tb_cadastro
ALTER TABLE tb_cadastro
ADD COLUMN rank VARCHAR(255);
