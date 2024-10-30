ALTER TABLE media_file
ALTER COLUMN id SET DEFAULT uuid_generate_v4();