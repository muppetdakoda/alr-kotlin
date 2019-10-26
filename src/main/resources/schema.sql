CREATE TABLE ALR_ITEM (
    itemID          VARCHAR(128) PRIMARY KEY NOT NULL,
    itemName        VARCHAR(128) NOT NULL,
    itemType        VARCHAR(128) NOT NULL,
    itemDescription VARCHAR(128) NOT NULL,
    itemValue       INTEGER NOT NULL
);