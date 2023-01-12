<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="jumbotron jumbotron-billboard">
	<div class="img"></div>
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h2>${Titolo}</h2>
			</div>
		</div>
	</div>
</div>
<section class="container">
	<div class="portlet light bordered">
		<div class="portlet-title tabbable-line">
		 	 <div class="caption font-blue-madison">
            	<i class="icon-settings oi oi-person"></i>
             	<span class="caption-subject bold uppercase">Dati Prenotazione</span>
            </div>
      		
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
					<form:form  method="POST" modelAttribute="auto">
					<form:errors path="*" cssClass="alert alert-danger" element="div"/> 
					
					<div class="form-body">
					
						<div class="form-group">
							<label for="targa"><spring:message code="insauto.form.targa.label"/></label>
							<form:input id="dataInizio" path="dataInizio" type="text" class="form-control" placeholder="Data Inizio"/>  
							<form:errors path="dataInizio" cssClass="text-danger"/>
						</div>
						
						<div class="form-group">
							<label for="dataFine"><spring:message code="insauto.form.marca.label"/></label>
							<form:input id="dataFine" path="dataFine" type="text" class="form-control" placeholder="Data Fine"/>  
							<form:errors path="dataFine" cssClass="text-danger"/>
						</div>
						
						<hr class="line-form">
						
						<div class="form-actions">
							<input type="submit" id="btnAdd" class="btn btn-green form-buttons" value = <spring:message code="insauto.form.btnAdd.label"/> />
							
							<a href="<spring:url value="/clienti/" /> " id="btnAbort" class="btn btn-default form-buttons" >
								<spring:message code="insauto.form.btnAbort.label"/>
							</a>
						</div>
					</div>
					
					</form:form>
				</div>

				
			</div>
		</div>
	</div>
</section>