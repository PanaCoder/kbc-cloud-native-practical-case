create table COCKTAIL_SHOPPING_LIST
(
    ID               UUID PRIMARY KEY,
    COCKTAIL_ID      UUID,
    SHOPPING_LIST_ID UUID,
    CONSTRAINT "COCKTAIL_SHOPPING_LIST_pk"
        UNIQUE (COCKTAIL_ID, SHOPPING_LIST_ID)
)