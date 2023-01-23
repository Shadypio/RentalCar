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
				Risultati Ricerca: <small>Trovate ${carsAmount} Auto</small>
			</h3>
		</div>
		<div class="col-md-6 col-sm-6">
			<a href="<spring:url value="/car/add" /> "
				style="margin-left: 20px;" class="btn btn-success float-right">Nuova
				Auto</a>
		</div>

		<c:choose>
         
         <c:when test = "${carsAmount == 0}">
            <h3 class="page-title">
				Nel nostro catalogo non sono presenti auto
			</h3>
         </c:when>
         
         
         
         <c:otherwise>
           <c:if test="${alreadyRented != null}">
				<div class="alert alert-danger">
					${alreadyRented}
				</div>
			</c:if>

			<table id="auto" class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>Targa</th>
						<th>Marca</th>
						<th>Modello</th>
						<th>Categoria</th>
						<th>Anno Immatricolazione</th>
						<th>Prenotata</th>
					</tr>
				</thead>
				<tfoot>
				</tfoot>
				<tbody>
					<c:forEach items="${cars}" var="car">
						<tr>
							<td>${car.licensePlate}</td>
							<td>${car.brand}</td>
							<td>${car.model}</td>
							<td>${car.category}</td>
							<td>${car.year}</td>
							<c:if test="${car.rental != null}">
								<td>Sì</td>
							</c:if>
							<c:if test="${car.rental == null}">
								<td>No</td>
							</c:if>

							<td><a
								href=" <spring:url value="/car/detailscar/${car.licensePlate}" /> "
								class="btn btn-primary"> <span class="oi oi-plus" /></span>
									Dettaglio
							</a></td>
							<td><c:if test="${car.rental == null}">
									<a
										href="<spring:url value="/rental/add/${car.licensePlate}" /> "
										class="btn btn-warning table-buttons"> <span
										class="oi oi-pencil"></span> Prenota Ora
									</a>
								</c:if></td>
							<td><a
								href="<spring:url value="/car/delete/${car.licensePlate}" /> "
								class="btn btn-danger table-buttons"> <span
									class="oi oi-trash" /></span> Elimina
							</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
         </c:otherwise>
		</c:choose>
	</div>
	

</section>

