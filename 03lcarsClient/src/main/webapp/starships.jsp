 <%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
 
<div class="segment">
<!-- 
	 <div class="head">
		<h2>Starship List</h2>
	</div>
	-->
	<div>
		<display:table name="applicationScope.starships" sort="list" pagesize="10" decorator="com.plaidman1701.lcarsclient03.ui.Timedecorator" >
			<display:column property="name" sortName="name" sortable="true"/>
			<display:column property="registry" sortName="registry" sortable="true"/>
			<display:column property="launched" sortName="launched" sortable="true"/>
			<display:column property="vesselclass" sortName="class" title="class" sortable="true"/>
			<display:column property="status" sortName="status" sortable="true"/>
			
			<display:setProperty name="paging.banner.placement" value="bottom"/>
		</display:table>
	</div>
</div>