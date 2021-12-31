origin -> https://www.youtube.com/watch?v=tUd-NJ6OW-8&t=1272s


persistence.xml 

the following fields need to be changed:
<PORT>
<YOUR_USERDB>
<YOUR_PASSWORDDB>


<?xml version="1.0" encoding="UTF-8"?>


<persistence version="2.1"
    xmlns="http://xmlns.jcp.org/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd">

	<persistence-unit name="BookUnit">
		<properties>
		    <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:<PORT>/booksdb?useUnicode=true&amp;useJDBCCompliantTimezoneShift=true&amp;useLegacyDatetimeCode=false&amp;serverTimezone=UTC"/>
			<property name="javax.persistence.jdbc.user" value="<YOUR_USERDB>"/>
			<property name="javax.persistence.jdbc.password" value="<YOUR_PASSWORDDB>"/>
			<property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver"/>
			
			<property name="hibernate.show_sql" value="true"/>
			<property name="hibernate.format_sql" value="true"/>
		
            
		</properties>
	</persistence-unit>
</persistence>