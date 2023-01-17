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
             	<span class="caption-subject bold uppercase"><spring:message code="insutente.form.titolo.label"/></span>
            </div>
            
            
            <section class = "locale-link-left"> 
            	<a href="?language=en"><img src="<c:url value="/img/US.png" />"></a> - 
            	<a href="?language=it"><img src="<c:url value="/img/IT.png" />"></a>                
      		</section> 
      		
		</div>
		<div class="portlet-body form">
			<div class="tab-content" id="myTabContent">
			
				<!-- Visualizza l'alert -->
				<c:if test="${saved}">
					<div class="alert alert-success" role="alert">
	  					<spring:message code="insutente.form.alert.label"/>
					</div>
				</c:if>
				
				<c:if test="${error}">
					<div class="alert alert-warning" role="alert">
	  					<spring:message code="insutente.form.warning.label"/>
					</div>
				</c:if>
				
				<!-- Form Dati Utente -->
				<div class="tab-pane fade show active" id="dati" role="tabpanel" aria-labelledby="dati-tab">
					<form:form  method="POST" modelAttribute="utente">
					<form:errors path="*" cssClass="alert alert-danger" element="div"/> 
					
					<div class="form-body">
					
						<div class="form-group">
							<label for="nome"><spring:message code="insutente.form.nome.label"/></label>
							<form:input id="nome" path="nome" type="text" class="form-control" placeholder="Nome"/>  
							<form:errors path="nome" cssClass="text-danger"/>
						</div>
						
						<div class="form-group">
							<label for="cognome"><spring:message code="insutente.form.cognome.label"/></label>
							<form:input id="cognome" path="cognome" type="text" class="form-control" placeholder="Cognome"/>  
							<form:errors path="cognome" cssClass="text-danger"/>
						</div>
						
						<div class="form-group">
							<label for="dataDiNascita"><spring:message code="insutente.form.datadinascita.label"/></label>
							<form:input id="dataDiNascita" path="dataDiNascita" type="date" 
							min="1950-01-01" max="2004-12-31"
							class="form-control" placeholder="Data di nascita"/>  
							<form:errors path="dataDiNascita" cssClass="text-danger"/>
						</div>
						
						<div class="form-group">
							<label for="username"><spring:message code="insutente.form.username.label"/></label>
							<form:input id="username" path="username" type="text" class="form-control" placeholder="Username"/>  
							<form:errors path="username" cssClass="text-danger"/>
						</div>
						
						<div class="form-group">
							<label for="password"><spring:message code="insutente.form.password.label"/></label>
							<form:input id="password" path="password" type="password" class="form-control" placeholder="Password"/>  
							<form:errors path="password" cssClass="text-danger"/>
						</div>
						
						
						<div class="form-group">
							<label for="ruolo"><spring:message code="insutente.form.ruolo.label"/></label>
							<div class="mt-radio-inline">
								<select name="ruolo" id="ruolo">
								  <c:forEach items="${ruoli}" var="ruolo">
								    <option value="${ruolo.idRuolo}">${ruolo.nomeRuolo}</option> 
								</c:forEach>
								</select>
							</div>
						</div>
						
						<hr class="line-form">
						
						<div class="form-actions">
							<input type="submit" id="btnAdd" class="btn btn-green form-buttons" value = <spring:message code="insauto.form.btnAdd.label"/> />
							
							<a href="<spring:url value="/utente/" /> " id="btnAbort" class="btn btn-default form-buttons" >
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