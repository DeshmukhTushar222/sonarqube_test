SET SERVEROUTPUT ON

DECLARE
  test PLS_INTEGER; -- This variable is implicitly initialized to NULL

  foo PLS_INTEGER NOT NULL; -- Noncompliant PLS-00218 a variable declared NOT NULL must have an initialization assignment

  TYPE myType IS RECORD(
    foo PLS_INTEGER NOT NULL, -- Non-Compliant PLS-00218 a variable declared NOT NULL must have an initialization assignment
    bar PLS_INTEGER NULL
  );
BEGIN
  IF test IS NULL
    DBMS_OUTPUT.PUT_LINE('test is NULL');
  ELSE
    DBMS_OUTPUT.PUT_LINE('test is NOT NULL');
  END IF;
END;
/
