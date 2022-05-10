drop table if exists ElectricityBillDetails;
drop table if exists DebtRate;
drop table if exists Building;
drop table if exists UserRoles;
drop table if exists Roles;
drop table if exists ElectricityBill;
drop table if exists Payment;
drop table if exists Users;
drop table if exists ElectricityBillDetails;
drop table if exists BuildingType;
drop table if exists Rate;
drop table if exists Provider;



create table Roles(
    roleId serial primary key,
    roleName varchar(255)
);

create table Users(
    userId serial primary key,
    username varchar(100),
    password varchar(100),
    firstName varchar(100),
    lastName varchar(100)
);

create table UserRoles(
    userId int references Users(userId) ON DELETE CASCADE,
    roleId int references Roles(roleId) ON DELETE CASCADE,
    primary key (userId, roleId)
);

create table Provider(
    providerId serial primary key,
    name varchar(100),
    description text,
    contactNumber varchar(30)
);

create table Rate(
    rateId serial primary key,
    pricePerUnit int,
    providerId int references Provider(providerId) ON DELETE CASCADE,
    rateDescription varchar(255),
    rateTypeName varchar(255)
);

create table DebtRate(
    debtId serial primary key,
    rateName varchar(100),
    addedPricePerUnit int
);

create table BuildingType(
    typeId serial primary key,
    name varchar(100),
    rateId int references Rate(rateId) ON DELETE CASCADE
);

create table Payment(
    paymentId serial primary key,
    accountNumber varchar(20),
    userId int references Users(userId) ON DELETE CASCADE,
    paymentDate date
);

create table Building (
    buildingId serial primary key,
    address varchar(255),
    buildingTypeId int references BuildingType(typeId) ON DELETE CASCADE,
    userId int references Users(userId) ON DELETE CASCADE
);

create table ElectricityBill(
    electroBillId serial primary key,
    userId int references Users(userId) ON DELETE CASCADE,
    unitsUsed int,
    startPeriod date,
    endPeriod date,
    totalSum int
);

create table ElectricityBillDetails(
    detailsId serial primary key,
    electroBillId int references ElectricityBill(electroBillId) ON DELETE CASCADE,
    providerId int references Provider(providerId) ON DELETE CASCADE,
    paymentId int references Payment(paymentId) ON DELETE CASCADE,
    debtId int references DebtRate(debtId) ON DELETE CASCADE
);