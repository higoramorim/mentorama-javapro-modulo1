// 20210904122726
// http://localhost:8080/v3/api-docs

{
  "openapi": "3.0.1",
  "info": {
    "title": "OpenAPI definition",
    "version": "v0"
  },
  "servers": [
    {
      "url": "http://localhost:8080",
      "description": "Generated server url"
    }
  ],
  "paths": {
    "/alunos/atualiza-nome": {
      "put": {
        "tags": [
          "cadastra-aluno-rest"
        ],
        "operationId": "updateName",
        "requestBody": {
          "content": {
            "application/json": {
              "schema": {
                "$ref": "#/components/schemas/Aluno"
              }
            }
          },
          "required": true
        },
        "responses": {
          "200": {
            "description": "OK",
            "content": {
              "*/*": {
                "schema": {
                  "type": "string"
                }
              }
            }
          }
        }
      }
    },
    "/alunos/atualiza-idade": {
      "put": {
        "tags": [
          "cadastra-aluno-rest"
        ],
        "operationId": "updateAge",
        "requestBody": {
          "content": {
            "application/json": {
              "schema": {
                "$ref": "#/components/schemas/Aluno"
              }
            }
          },
          "required": true
        },
        "responses": {
          "200": {
            "description": "OK",
            "content": {
              "*/*": {
                "schema": {
                  "type": "string"
                }
              }
            }
          }
        }
      }
    },
    "/alunos": {
      "get": {
        "tags": [
          "cadastra-aluno-rest"
        ],
        "operationId": "findAll",
        "responses": {
          "200": {
            "description": "OK",
            "content": {
              "*/*": {
                "schema": {
                  "type": "array",
                  "items": {
                    "$ref": "#/components/schemas/Aluno"
                  }
                }
              }
            }
          }
        }
      },
      "post": {
        "tags": [
          "cadastra-aluno-rest"
        ],
        "operationId": "add",
        "requestBody": {
          "content": {
            "application/json": {
              "schema": {
                "$ref": "#/components/schemas/Aluno"
              }
            }
          },
          "required": true
        },
        "responses": {
          "200": {
            "description": "OK",
            "content": {
              "*/*": {
                "schema": {
                  "type": "integer",
                  "format": "int32"
                }
              }
            }
          }
        }
      }
    },
    "/alunos/{id}": {
      "get": {
        "tags": [
          "cadastra-aluno-rest"
        ],
        "operationId": "findById",
        "parameters": [
          {
            "name": "id",
            "in": "path",
            "required": true,
            "schema": {
              "type": "integer",
              "format": "int32"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/Aluno"
                }
              }
            }
          }
        }
      },
      "delete": {
        "tags": [
          "cadastra-aluno-rest"
        ],
        "operationId": "delete",
        "parameters": [
          {
            "name": "id",
            "in": "path",
            "required": true,
            "schema": {
              "type": "integer",
              "format": "int32"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "content": {
              "*/*": {
                "schema": {
                  "type": "string"
                }
              }
            }
          }
        }
      }
    },
    "/alunos/filtrar-por-nome": {
      "get": {
        "tags": [
          "cadastra-aluno-rest"
        ],
        "operationId": "findByFilterName",
        "parameters": [
          {
            "name": "nome",
            "in": "query",
            "required": false,
            "schema": {
              "type": "string"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "content": {
              "*/*": {
                "schema": {
                  "type": "array",
                  "items": {
                    "$ref": "#/components/schemas/Aluno"
                  }
                }
              }
            }
          }
        }
      }
    },
    "/alunos/filtrar-por-idade": {
      "get": {
        "tags": [
          "cadastra-aluno-rest"
        ],
        "operationId": "findByFilterAge",
        "parameters": [
          {
            "name": "idade",
            "in": "query",
            "required": false,
            "schema": {
              "type": "string"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "content": {
              "*/*": {
                "schema": {
                  "type": "array",
                  "items": {
                    "$ref": "#/components/schemas/Aluno"
                  }
                }
              }
            }
          }
        }
      }
    }
  },
  "components": {
    "schemas": {
      "Aluno": {
        "type": "object",
        "properties": {
          "id": {
            "type": "integer",
            "format": "int32"
          },
          "nome": {
            "type": "string"
          },
          "idade": {
            "type": "string"
          }
        }
      }
    }
  }
}
