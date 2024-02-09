CREATE TABLE "post" (
	id uuid NOT NULL DEFAULT gen_random_uuid(),
	title varchar NOT NULL,
	description text NOT NULL,
	creation_date date NOT NULL DEFAULT current_date,
	goal double precision NOT NULL,
	id_user uuid NOT NULL,
	end_date date NOT NULL,
	CONSTRAINT post_pk PRIMARY KEY (id),
    CONSTRAINT end_date_after_creation CHECK (end_date > creation_date)
);

CREATE TABLE "user" (
	id uuid NOT NULL DEFAULT gen_random_uuid(),
	first_name varchar(150) NOT NULL,
	last_name varchar NOT NULL,
	email varchar NOT NULL,
	password varchar NOT NULL,
	CONSTRAINT user_pk PRIMARY KEY (id)
);

CREATE TABLE "donation" (
	id uuid NOT NULL DEFAULT gen_random_uuid(),
	description text,
	date date NOT NULL DEFAULT current_date,
	id_post uuid NOT NULL,
	id_user uuid NOT NULL,
	is_anonymous boolean NOT NULL DEFAULT false,
	CONSTRAINT backers_pk PRIMARY KEY (id)
);

CREATE TABLE "faq" (
	id uuid NOT NULL DEFAULT gen_random_uuid(),
	question varchar NOT NULL,
	answer varchar NOT NULL,
	id_post uuid NOT NULL,
	CONSTRAINT faq_pk PRIMARY KEY (id)
);

CREATE TABLE "update" (
	id uuid NOT NULL DEFAULT gen_random_uuid(),
	title varchar NOT NULL,
	content text NOT NULL,
	id_post uuid NOT NULL,
	date date NOT NULL DEFAULT current_date,
	CONSTRAINT updates_pk PRIMARY KEY (id)
);

CREATE TABLE "reward" (
	id uuid NOT NULL,
	tiers double precision NOT NULL,
	title varchar,
	description text NOT NULL,
	estimated_delivery_date date NOT NULL,
	id_post uuid NOT NULL,
	CONSTRAINT rewards_pk PRIMARY KEY (id)
);

CREATE TABLE "donation_cache" (
	id uuid NOT NULL DEFAULT gen_random_uuid(),
	amount double precision NOT NULL,
	id_donation uuid NOT NULL,
	CONSTRAINT funding_cache_pk PRIMARY KEY (id)
);

ALTER TABLE "post" ADD CONSTRAINT user_fk FOREIGN KEY (id_user)
REFERENCES "user" (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE "donation" ADD CONSTRAINT post_fk FOREIGN KEY (id_post)
REFERENCES "post" (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE "reward" ADD CONSTRAINT post_fk FOREIGN KEY (id_post)
REFERENCES "post" (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE "faq" ADD CONSTRAINT post_fk FOREIGN KEY (id_post)
REFERENCES "post" (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE "update" ADD CONSTRAINT post_fk FOREIGN KEY (id_post)
REFERENCES post (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE "donation_cache" ADD CONSTRAINT donation_fk FOREIGN KEY (id_donation)
REFERENCES donation (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE "donation" ADD CONSTRAINT user_fk FOREIGN KEY (id_user)
REFERENCES "user" (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;

CREATE TABLE "update_comment" (
	id uuid NOT NULL DEFAULT gen_random_uuid(),
	value text NOT NULL,
    "time" timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	id_user uuid NOT NULL,
	id_update uuid NOT NULL,
	CONSTRAINT update_comment_pk PRIMARY KEY (id)
);

ALTER TABLE "update_comment" ADD CONSTRAINT user_fk FOREIGN KEY (id_user)
REFERENCES "user" (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE "update_comment" ADD CONSTRAINT update_fk FOREIGN KEY (id_update)
REFERENCES update (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;

CREATE TABLE "rewarded" (
	id uuid NOT NULL DEFAULT gen_random_uuid(),
	id_user uuid NOT NULL,
	id_reward uuid NOT NULL,
	CONSTRAINT rewarded_pk PRIMARY KEY (id)
);

ALTER TABLE "rewarded" ADD CONSTRAINT user_fk FOREIGN KEY (id_user)
REFERENCES "user" (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE "rewarded" ADD CONSTRAINT reward_fk FOREIGN KEY (id_reward)
REFERENCES reward (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE "rewarded" ADD CONSTRAINT rewarded_uq UNIQUE (id_reward);
