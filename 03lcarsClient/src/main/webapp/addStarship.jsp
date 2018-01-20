<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="topsegment">

	<div class="head">
		<h2>Add Starship</h2>
	</div>
	
	<div class="formdiv">
		<form action="${pageContext.request.contextPath}/starshipApp"
			method="POST" accept-charset="utf-8">

			<label for="registryLbl">Registry:</label> <input type="text"
				name="registry" value="" id="registry" title="Registry" /> <label
				for="nameLbl">Name:</label> <input type="text" name="name" value=""
				id="name" title="Name" /> <label for="vesselClassLbl">Class:</label>

			<select name="vesselclass">
				<option value="galaxy">galaxy</option>
				<option value="miranda">miranda</option>
				<option value="oberth">oberth</option>
			</select> <br />

			<label for="statusLbl">Status:</label> <input class="classradio"
				type="radio" name="status" value="active" checked>active <input
				class="classradio" type="radio" name="status" value="lost">lost
			<input class="classradio" type="radio" name="status"
				value="destroyed">destroyed<br>

			<label for="launchedLbl">Launched:</label> <input type="text"
				name="launched" value="" id="launched" title="Launched"
				placeholder="YYYY/MM/DD" />

			<div class="submit">
				<input type="hidden" name="action" value="service.addStarship" /> <input
					type="submit" name="submit" value="Add Starship" id="submit" />
			</div>
			
		</form>
	</div>
	
	<div class="formdiv">

		<c:if test="${fn:length( addResponseCode ) gt 0}">
			<c:forEach var="responseCode" items="${addResponseCode}">
				<c:set var="code" value="${responseCode.code}" />
				<c:set var="desc" value="${responseCode.desc}" />
				<c:out value="Result Code: ${code} Description:" />
				<br />
				<c:out value="${desc}" />
			</c:forEach>
		</c:if>

	</div>
</div>