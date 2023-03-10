<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

	<% LocalDate currentDate = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");%>
<div class="jumbotron jumbotron-billboard">
	<div class="img"></div>
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h2>${head}</h2>
				<h4> ${car.licensePlate} - ${car.brand} ${car.model} (${car.year})</h4>
				<h4> ${customer.firstName} ${customer.lastName} - ${customer.username}</h4>
			</div>
		</div>
	</div>
</div>
<section class="container">
	<div class="portlet light bordered">
		<div class="portlet-title tabbable-line">
		 	 <div class="caption font-blue-madison">
            	<i class="icon-settings oi oi-person"></i>
             	<span class="caption-subject bold uppercase"><spring:message code="insprenotazione.form.titolo.label"/></span>
            </div>         

         <section class = "locale-link-left"> 
            	<a href="?language=en"><img src="<c:url value="/img/US.png" />"></a> - 
            	<a href="?language=it"><img src="<c:url value="/img/IT.png" />"></a>                
      		</section>
			<c:if test="${errorDate != null}">
				<div class="alert alert-danger">
					${errorDate}
				</div>
			</c:if>

		</div>
		<div class="portlet-body form">
			<div class="tab-content" id="myTabContent">
			
				<!-- Visualizza l'alert -->
				<c:if test="${saved}">
					<div class="alert alert-success" role="alert">
	  					Prenotazione Effettuata!
					</div>
				</c:if>
				
				<c:if test="${error}">
					<div class="alert alert-warning" role="alert">
	  					Errore nella prenotazione.
					</div>
				</c:if>
				
				<!-- Form Dati Prenotazione -->
				<div class="tab-pane fade show active" id="dati" role="tabpanel" aria-labelledby="dati-tab">
					<form:form  method="POST" modelAttribute="rental">
					<form:errors path="*" cssClass="alert alert-danger" element="div"/> 
					
					<div class="form-body">
					
						<div class="form-group">
							<label for="startDate"><spring:message code="insprenotazione.form.dataInizio.label"/></label>
							<form:input id="startDate" path="startDate" type="date" 
							min='<%=""+currentDate.format(formatter)%>' 
							max="2023-12-31"
							class="form-control" placeholder="Data Inizio" required="required"/>  
							<form:errors path="startDate" cssClass="text-danger"/>
						</div>
						
						<div class="form-group">
							<label for="endDate"><spring:message code="insprenotazione.form.dataFine.label"/></label>
							<form:input id="endDate" path="endDate" type="date" 
							min='<%=""+currentDate.format(formatter)%>' 
							max="2023-12-31"
							class="form-control" placeholder="Data Fine" required="required"/>  
							<form:errors path="endDate" cssClass="text-danger"/>
						</div>
						
						<hr class="line-form">
						
						<div class="form-actions">
							<input type="submit" id="btnAdd" class="btn btn-green form-buttons" value = <spring:message code="insprenotazione.form.btnAdd.label"/> />
							
							<a href="javascript:history.back()" id="btnAbort" class="btn btn-default form-buttons" >
								<spring:message code="insprenotazione.form.btnAbort.label"/>
							</a>
						</div>
					</div>
					
					</form:form>
				</div>

				
			</div>
		</div>
	</div>
</section>