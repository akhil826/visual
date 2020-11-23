
bootstrapValidate(
   '#email',
  
   'endsWith:@gmail.com:input should be end with @gmail.com'
 );
bootstrapValidate(
		'#firstname',
		'max:6:please provide name max to 6'
		
);
bootstrapValidate(
		'#lastname',
		'max:8:please provide name max to 6'
		
);


bootstrapValidate(
		'#password',
		'regex:[A-Za-z0-9]{8}:Must contain at least one uppercase and lowercase letter, and at least 8 or more characters'
		
);
