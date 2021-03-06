package com.everis.d4i.tutorial.controllers.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.everis.d4i.tutorial.controllers.CategoryController;
import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.CategoryRest;
import com.everis.d4i.tutorial.responses.NetflixResponse;
import com.everis.d4i.tutorial.services.CategoryService;
import com.everis.d4i.tutorial.utils.constants.CommonConstants;
import com.everis.d4i.tutorial.utils.constants.ExceptionConstants;
import com.everis.d4i.tutorial.utils.constants.RestConstants;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_CATEGORY)
public class CategoryControllerImpl implements CategoryController {

	@Autowired
	private CategoryService categoryService;

	@ApiOperation(value = "Mostrar todas las categorias")
	@ApiResponses(value = {
	@ApiResponse(code = 200, message = CommonConstants.OK, response = CategoryRest.class),
	@ApiResponse(code = 404, message = ExceptionConstants.MESSAGE_INEXISTENT_CATEGORY),
	@ApiResponse(code = 500, message = ExceptionConstants.INTERNAL_SERVER_ERROR)
	})
	
	@Override
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public NetflixResponse<List<CategoryRest>> getCategories() throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				categoryService.getCategories());
	}
	
	@ApiOperation(value = "Crear una nueva categoria")
	@ApiResponses(value = {
	@ApiResponse(code = 201, message = CommonConstants.CREATED, response = CategoryRest.class),
	@ApiResponse(code = 400, message = ExceptionConstants.BAD_REQUEST),
	@ApiResponse(code = 401, message = ExceptionConstants.UNAUTHORIZED),
	@ApiResponse(code = 500, message = ExceptionConstants.INTERNAL_SERVER_ERROR)
	})

	@Override
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = RestConstants.RESOURCE_CREATE, produces = MediaType.APPLICATION_JSON_VALUE)
	public NetflixResponse<CategoryRest> createCategory(
			@ApiParam(value = RestConstants.PARAMETER_CATEGORY, required = true) @RequestBody @Valid final CategoryRest categoryRest)
			throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				categoryService.createCategories(categoryRest));
	}

}
