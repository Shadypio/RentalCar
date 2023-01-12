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
             	<span class="caption-subject bold uppercase"><spring:message code="insauto.form.titolo.label"/></span>
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
	  					<spring:message code="insauto.form.alert.label"/>
					</div>
				</c:if>
				
				<c:if test="${error}">
					<div class="alert alert-warning" role="alert">
	  					<spring:message code="insauto.form.warning.label"/>
					</div>
				</c:if>
				
				<!-- Form Dati Auto -->
				<div class="tab-pane fade show active" id="dati" role="tabpanel" aria-labelledby="dati-tab">
					<form:form  method="POST" modelAttribute="auto">
					<form:errors path="*" cssClass="alert alert-danger" element="div"/> 
					
					<div class="form-body">
					
						<div class="form-group">
							<label for="targa"><spring:message code="insauto.form.targa.label"/></label>
							<form:input id="targa" path="targa" type="text" class="form-control" placeholder="Targa"/>  
							<form:errors path="targa" cssClass="text-danger"/>
						</div>
						
						<div class="form-group">
							<label for="marca"><spring:message code="insauto.form.marca.label"/></label>
							<form:input id="marca" path="marca" type="text" class="form-control" placeholder="Marca"/>  
							<form:errors path="marca" cssClass="text-danger"/>
						</div>
						
						<div class="form-group">
							<label for="modello"><spring:message code="insauto.form.modello.label"/></label>
							<form:input id="modello" path="modello" type="text" class="form-control" placeholder="Modello"/>  
							<form:errors path="modello" cssClass="text-danger"/>
						</div>
						
						<div class="form-group">
							<label for="categoria"><spring:message code="insauto.form.categoria.label"/></label>
							<form:input id="categoria" path="categoria" type="text" class="form-control" placeholder="Categoria"/>  
							<form:errors path="categoria" cssClass="text-danger"/>
						</div>
						
						<div class="form-group">
							<label for="anno"><spring:message code="insauto.form.anno.label"/></label>
							<form:input id="anno" path="anno" type="text" class="form-control" placeholder="Anno di immatricolazione"/>  
							<form:errors path="anno" cssClass="text-danger"/>
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