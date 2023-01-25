<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="jumbotron jumbotron-billboard">
	<div class="img"></div>
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h2>${head}</h2>
				<p>${subheading}</p>
			</div>
		</div>
	</div>
</div>
<section class="container">
	<div class="row">
		<div class="col-md-6 col-sm-6">
			<h3 class="page-title">
				Risultati Ricerca: <small>Trovati ${customersAmount} Utenti</small>
			</h3>
		</div>
		<div class="col-md-6 col-sm-6">
			<a href="<spring:url value="/customer/add" /> "
				style="margin-left: 20px;" class="btn btn-success float-right">Nuovo
				Utente</a>
		</div>

			<c:choose>

				<c:when test="${customersAmount == 0}">
					<h3 class="page-title">Alla piattaforma non è
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
				<c:forEach items="${customers}" var="customer">
					<tr>
						<td>${customer.id}</td>
						<td>${customer.firstName}</td>
						<td>${customer.lastName}</td>
						<td>${customer.username}</td>
						<td>${customer.dateOfBirth}</td>
						<c:if test="${customer.enabled}">
								<td>Sì</td>
							</c:if>
							<c:if test="${!customer.enabled}">
								<td>No</td>
							</c:if>
						<td>${customer.role.roleName}</td>
						<td><a
							href=" <spring:url value="/customer/detailscustomer/${customer.id}" /> "
							class="btn btn-primary"> <span class="oi oi-plus" /></span>
								Dettaglio
						</a></td>

						<td>
						<c:if test="${customer.role.id == 1}">
							<a
								href="<spring:url value="/customer/edit/${customer.id}" /> "
								class="btn btn-warning table-buttons disabled"> <span
								class="oi oi-pencil"></span> Modifica
							</a>
						</c:if>
						<c:if test="${customer.role.id != 1}">
							<a
								href="<spring:url value="/customer/edit/${customer.id}" /> "
								class="btn btn-warning table-buttons"> <span
								class="oi oi-pencil"></span> Modifica
							</a>
						</c:if>		
						</td>


								<c:if test="${customer.enabled}">			
								<td>
								<c:if test="${customer.role.id == 1}">
									<a
										href="<spring:url value="/customer/toggleabilitation/${customer.id}"/> "
										class="btn btn-danger table-buttons disabled "> <span
											class="oi oi-circle-x"  /></span> Disabilita
									</a>
								</c:if>
								<c:if test="${customer.role.id != 1}">
									<a
										href="<spring:url value="/customer/toggleabilitation/${customer.id}"/> "
										class="btn btn-danger table-buttons "> <span
											class="oi oi-circle-x"  /></span> Disabilita
									</a>
								</c:if>
								</td>
							</c:if>
						<c:if test="${!customer.enabled}">			
						<td><a
							href="<spring:url value="/customer/toggleabilitation/${customer.id}" /> "
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

