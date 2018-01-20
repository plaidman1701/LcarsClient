<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="topsegment">

	<div class="head">
		<h2>Find Starship</h2>
	</div>
	
	<div class="formdiv">
		<form action="${pageContext.request.contextPath}/starshipApp"
			method="POST" accept-charset="utf-8">

			<label for="stringToFindLbl">Registry:</label> <input type="text"
				name="stringToFind" value="" id="stringToFind"
				title="String To Find" />

			<div class="submit">
				<input type="hidden" name="action" value="service.findStarship" />
				<input type="submit" name="submit" value="Search" id="submit" />
			</div>
		</form>
	</div>
	
	<div class="formdiv">
		<c:if test="${fn:length( findResponseCode.code ) > 0}">
			<c:set var="code" value="${findResponseCode.code}" />
			<c:set var="desc" value="${findResponseCode.desc}" />
			<c:out value="Result Code: ${code} Description:" />
			<br />
			<c:out value="${desc}" />
		</c:if>
	</div>
</div>