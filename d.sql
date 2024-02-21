CREATE Table Client (
    id serial PRIMARY KEY,
    name VARCHAR (100)
);

CREATE Table Contract (
    id serial PRIMARY KEY,
    description TEXT,
    date_debut date not null,
    client_id int REFERENCES Client (id)
);

CREATE Table Intervation (
    id serial PRIMARY KEY,
    Contrat_id int REFERENCES Contract (id),
    Nbre_Employe int 
);

CREATE Table Qualification (
    id serial PRIMARY KEY,
    Description TEXT,
    tarif DECIMAL (10,2)
);


--------------------------------------------------------------------------------------Exercice 2------------------------------------------------------------------------

CREATE Table Expert (
    NumExp int PRIMARY KEY,
    NomExp VARCHAR (100),
    prenom VARCHAR (100),
    AdExp int not null,
    CpExp int not null
);
CREATE Table Agent (
    numAgent int PRIMARY KEY,
    nomAgent VARCHAR (100),
    prenomAgent VARCHAR (100),
    telAgent VARCHAR (15)
);

CREATE Table Accident (
    numAccident int PRIMARY KEY,
    lieuAccident VARCHAR (200),
    dateAccident DATE not null,
    heureAccident TIMESTAMP not null,
    circonstance TEXT,
    id_numAgent int REFERENCES Agent (numAgent)
);

create Table expertise (
    date date, 
    rapport TEXT,
    id_numExp REFERENCES Expert (NumExp),
    id_numAcc REFERENCES Accident (numAccident)
);
create Table vehicule (
    numMatricule int PRIMARY KEY,
    marque VARCHAR (100),
    Type VARCHAR (100),
    puissance int 
);

CREATE Table concerne (
    id_numAccident int,
    id_numMatricule int, 
    id_numAccident REFERENCES Accident (numAccident),
    id_numMatricule REFERENCES vehicule (numMatricule)
);

create Table client (
    numClient int PRIMARY KEY,
    nomClient VARCHAR (100),
    prenomClient VARCHAR (100),
    adClient int ,
    CPClient int ,
    vilClient VARCHAR (100),
    telClient VARCHAR (15)
);
create TABLE contrat (
    numContrat int PRIMARY KEY,
    typeContrat VARCHAR(100),
    dateContrat date not null,
    id_client int ,
    id client REFERENCES Client (numClient)
);