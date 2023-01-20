<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="jumbotron jumbotron-billboard">
	<div class="img"></div>
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h2>${Titolo}</h2>
				<p>${Titolo2}</p>
			</div>
		</div>
	</div>
</div>
<section class="container">
	<div class="row">
		<div class="col-md-6 col-sm-6">
			<h3 class="page-title">
				Risultati Ricerca: <small>Trovati ${numUtenti} Utenti</small>
			</h3>
		</div>
		<div class="col-md-6 col-sm-6">
			<a href="<spring:url value="/utente/aggiungi" /> "
				style="margin-left: 20px;" class="btn btn-success float-right">Nuovo
				Utente</a>
		</div>

			<c:choose>

				<c:when test="${numUtenti == 0}">
					<h3 class="page-title">Alla nostra piattaforma non è
						registrato alcun utente</h3>
				</c:when>



				<c:otherwise>
		
		<table id="utenti" class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Cognome</th>
					<th>Username</th>
					<th>Data di nascita</th>
					<th>Abilitato</th>
					<th>Ruolo</th>
				</tr>
			</thead>
			<tfoot>
			</tfoot>
			<tbody>
				<c:forEach items="${Utenti}" var="utente">
					<tr>
						<td>${utente.idUtente}</td>
						<td>${utente.nome}</td>
						<td>${utente.cognome}</td>
						<td>${utente.username}</td>
						<td>${utente.dataDiNascita}</td>
						<c:if test="${utente.abilitato}">
								<td>Sì</td>
							</c:if>
							<c:if test="${!utente.abilitato}">
								<td>No</td>
							</c:if>
						<td>${utente.ruolo.nomeRuolo}</td>
						<td><a
							href=" <spring:url value="/utente/infoutente/${utente.idUtente}" /> "
							class="btn btn-primary"> <span class="oi oi-plus" /></span>
								Dettaglio
						</a></td>
						<td><a
							href="<spring:url value="/utente/modifica/${utente.idUtente}" /> "
							class="btn btn-warning table-buttons"> <span
								class="oi oi-pencil"></span> Modifica
						</a></td>	
							<c:if test="${utente.abilitato}">			
								<td>
								<c:if test="${utente.ruolo.idRuolo == 1}">
									<a
										href="<spring:url value="/utente/disabilita/${utente.idUtente}"/> "
										class="btn btn-danger table-buttons disabled "> <span
											class="oi oi-circle-x"  /></span> Disabilita
									</a>
								</c:if>
								<c:if test="${utente.ruolo.idRuolo != 1}">
									<a
										href="<spring:url value="/utente/disabilita/${utente.idUtente}"/> "
										class="btn btn-danger table-buttons "> <span
											class="oi oi-circle-x"  /></span> Disabilita
									</a>
								</c:if>
								</td>
							</c:if>
						<c:if test="${!utente.abilitato}">			
						<td><a
							href="<spring:url value="/utente/abilita/${utente.idUtente}" /> "
							class="btn btn-success table-buttons"> <span
								class="oi oi-circle-check" /></span> Abilita
						</a></td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>

		</table>
		</c:otherwise>
		</c:choose>
	</div>
</section>

