Feature: Login

  Scenario: Login de ATSalud correcto
    Given ATS ingresa a formulario Login y selecciona campo Usuario
    Then ATS ingresa su correo "demo12@gmail.com"
    When ATS selecciona campo Contraseña
    Then ATS ingresa su clave "123456"
    And ATS selecciona botón Ingresar
