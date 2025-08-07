-- V3: Migrations para adicionar a tabela lider_tb_missoes
ALTER TABLE tb_missoes
ADD COLUMN lider VARCHAR(255);