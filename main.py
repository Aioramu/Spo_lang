from lexer import Lexer
from pars import Parser
from transfer_to_pn import PN
from stack_machine import stack_machine
from triad_processing import Triad
from thread_manager import Thread_manager
from my_thread import Thread


f = open('test.txt')
inp = f.read()
f.close()

print('\nlexer:')
l = Lexer()
tokens = l.lex(inp)

p = Parser(tokens)
pars = p.lang()
print('\nparser:', pars)

if pars:
    pn = PN(tokens)
    transfer, fun = pn.transfer_PN()

    tr = Triad(transfer, fun)
    t, val = tr.triad_op()

    for i in range(len(fun)):
        print("\nFunctions triads processing:")
        triad = Triad(fun[i][-1], fun)
        fun[i][-1] = triad.triad_op(False)

    sm = stack_machine(t, val, fun)
    thread_flag = 'n'
    print('\nDo you want to run the program in multi-thread mode? [y/n]')
    thread_flag = input()
    if thread_flag == 'y':
        main_th = Thread('main', stack_machine(t, val, fun))
        th_manager = Thread_manager([main_th])
        th_manager.run()
        pass
    else:
        print('\nstack machine\nvalue table:')
        sm.stack_machine_run()
