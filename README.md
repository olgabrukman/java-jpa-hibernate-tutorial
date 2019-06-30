Java Intellij JPA Hibernate Tutorial
======

Prerequisite Steps Before Running the Project
-----------------------------------------------
1. Install [mysql on ubuntu](https://www.linode.com/docs/databases/mysql/install-mysql-on-ubuntu-14-04). 
Set password **root** for user *root* (important!).
2. Access mysql by cli and create new database **JavaHelps**:
    1. mysql -u root -p
    2. password: root
    3. create database JavaHelps;
3. [Create new project with JPA facet](https://www.jetbrains.com/help/idea/2016.1/enabling-jpa-support.html?origin=old_help):
    - Choose Hibernate as a "transformer"
4. [Set hibernate annotation processor](https://docs.jboss.org/hibernate/stable/jpamodelgen/reference/en-US/html_single/#d0e307)
5. [Define new datasource](https://www.jetbrains.com/help/idea/2016.1/working-with-the-database-tool-window.html?origin=old_help&search=datasource#create_data_source). 
    * The result of this dialog box is written into file  *persistence.xml*.
    * Set additional parameters to allow automatic creation/destruction  of entities in the DB.


