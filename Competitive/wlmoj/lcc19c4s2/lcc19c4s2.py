tape = ['']
n = int(input())

pos = 0

for i in range(0, n):
    command = input()
    if command == 'h' and pos != 0:
        pos -= 1
    elif command == 'l':
        pos += 1
        if len(tape) == pos:
            tape.append('')
    elif command.startswith('r'):
        tape[pos] = command[1:]

print(''.join(tape))
