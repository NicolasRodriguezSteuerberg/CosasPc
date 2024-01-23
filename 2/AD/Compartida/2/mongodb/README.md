# MongoDB Commands Cheat Sheet
1. [Entering MongoDB](#entering-mongodb)
2. [Viewing](#viewing)
    1. [Show Contents of a Collection](#show-contents-of-a-collection)
    2. [Filtering](#filtering)
    3. [Containing a Part of Text](#containing-a-part-of-text)
3. [Show Collections](#show-collections)
4. [Databases](#databases)
5. [Deletion](#deletion)
    1. [Collection Contents](#collection-contents)
    2. [Collections](#collections)
    3. [Databases](#databases-1)
6. [Creation](#creation)
    1. [Create a Data/Collection](#create-a-datacollection)
    2. [Create a Row with Personalized ID](#create-a-row-with-personalized-id)
7. [Update](#update)
8. [Connect to a Database or Create One](#connect-to-a-database-or-create-one)


## Entering MongoDB
- `sudo systemctl start mongod`
- `mongosh`

## Viewing

### Show Contents of a Collection
- Show all: `db.collectionName.find()` 
- Show only the first: `db.collectionName.findOne()`
- Show a specific column:
  - `db.collectionName.find({column:"value"})`
    - if the column is composite, use quotes (`"column.column": value`)

### Filtering
- db.people({"name":**{$eq:"luis"}**})
    - those named Luis
- db.people({"name":**{$ne:"luis"}**})
    - those not named Luis
- db.people({"age":**{$gt:30}**})
    - older than 30
- db.people({"age":{$gte:31}})
    - 31 or older
- db.people({"age":**{$lt:30}**})
    - younger than 30
- db.people({"age":**{$lte:31}**})
    - 31 or younger
- db.people({"age":**{$ne:30}**})
    - those without the age field or different from 30
- db.people.find({"name":**{$in:["luis","ana"]}**})
    - those named Luis or Ana
- db.people.find({"name":**{$nin:["luis","ana"]}**})
    - those not named Luis nor Ana
    - `$nin` includes those without that field
    - db.people.find( {age: **{exists: true, $nin:[30,40]}** } )
        - only those with the age field and not 30 or 40
- db.people.find( { **$or: [** {name:"felix"} , {age:31} **]** })
    - either one, or who name felix or if them have 31
- db.people.find( { **$and: [** {name:"ana"} , {age: {$gte:31} } **]** } )
    - people who name Ana and have more than 31
- db.people.find( {age: {**$not:**{$gt:30}} } ) -> those without age or aged 31 and below
  - `$not:` always includes when that field does NOT exist
- db.people.find( **{}, {age: 1}** )
    - show only the age field (all ages)
- db.people.find( {}, {age: 0} )
    - show everything except age
- db.people.find( {}, {age: 1, name:1} )
    - show age and name
- db.people.find( {}, {age: 1, name:1, _id:0} )
    - to not show the id (otherwise, it always shows)
- db.people.find( {age:{$gt:30}}, {age: 1, name:1, _id:0} )
    - age older than 30 and only show age and name

### Containing a Part of Text
- db.people.find({name:**{$regex:"l"}**})
    - those with the letter 'l'
- db.people.find({name:{$regex:"**^l**"}})
    - those starting with the letter 'l'
- db.people.find({name:{`$regex:"s$"`}})
    - those ending with 's'
- db.people.find({name:**/i/**})
    - those with 'i'
- db.people.find({name:**{$in:[/u/,/x/]}**})
    - those with the letter U or X

## Show Collections
- `show collections`
- `show tables`
    - do the same

## Databases
- `show dbs`

## Deletion
### Collection Contents
- `db.people.deleteOne({...})`
  - specify which one to delete to avoid deleting the first one encountered (`...` is the condition)
- `db.people.deleteMany({})` 
  - delete all content
  - if you provide a condition, it deletes those matching the condition

### Collections
- `db.collectionName.drop()`

### Databases
- `db.dropDatabase()`

## Creation
### Create a Data/Collection
Collections are created by inserting a row:
- `db.collectionName.insertOne({"name":"luis", "numbers":[2,3,56,89]})`
    - if you create 2 fields that have the same name its only create the last one

### Create a row with personalized id
- `db.people.insertOne({_id:1, name:"Pedro"})`

## Update
- Replace entire document/row with new:
    - `db.people.replaceOne({_id:1},{name:"luis"})`
        - If it has a "hello" field, it replaces it with "name". If it has 4 fields, it replaces them with just "name".
    - `db.people.replaceOne({},{phone:4444})`
        - Replaces the first one it finds.

- Modify a document/row or add a field:
    - `db.people.updateOne({name:"Smith"},{$set:{children:2.5}})`
        - Searches for the first document/row with the "name" field and changes the second parameter. If it doesn't exist, it creates it.
        - CANNOT CHANGE THE ID
    - `db.people.updateOne({name:"Jones"}, {$set:{age:50}},{upsert:true})`
        - If it doesn't find the condition field, it creates it.

- Modify several/all documents/rows or add a field:
    - `db.people.updateMany({},{$set:{city:"NYC"}})`

- Delete a data from a document/row:
    - `db.people.updateOne({name:"Smith"},{$unset:{childre:443}})`
        - After the field you want to delete, you don't have to put the exact data of that field; you can put whatever you want.

- Modify multiple documents/rows:
    - `db.people.updateMany({name:"Smith"},{$set:{children:2.5}})`

- Increment a field:
    - `db.books.updateOne({_id:1}, {$inc:{stock:1}})`
        - The number you provide is how much it increments.

- Decrease a field:
    - `db.books.updateOne({_id:1}, {$inc:{stock:-1}})`
        - The number you provide is how much it decreases.

- Modify multiple fields:
    - `db.books.updateOne({_id:1}, {$inc:{stock:18},$set:{item:"ABCD"}})`
    - `db.books.updateOne({_id:1}, {$inc:{stock:5},$set:{item:"ABC123", "info.publisher":2222, tags:["software"], "ratings.1":{by:"xyz", rating: 3}}}`

## Connect to a Database or Create One
(If you create one without adding any collections, it won't appear in the show dbs list)
- `use databaseName`