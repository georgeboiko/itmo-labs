ORG 0x0000
MULTIPLIABLE: WORD 0x0078
RESULT: WORD 0x0000
MULTIPLIER: WORD 0x0005
COUNTER: WORD 0x0000
START: CLA
ADD RESULT
ADD MULTIPLIABLE
ST RESULT
CLA
ADD COUNTER
INC
ST COUNTER
SUB MULTIPLIER
BMI START
HLT
