---
title: Assignment 2
authors: Michael Lenehan
left-header: EE402 Object-Oriented Programming with Embedded Systems
right-header: \today
---

# Introduction

The aim of this assignment is to implement a graphical server application, which
will display the CPU Temperatures of the Client device in the form of a graph
against time. The Client device will connect to the Server, passing the current
temperature to be stored. The Server will store the last twenty input values,
graphing these along with an average temperature value for all currently
connected clients. The frequency at which the Client will send the temperature
reading to the Server must be variable, being set via the Server GUI.

The Server application must be able to handle multiple Client connections at any
time, The custom object type sent from the Client must include the following
information: Temperature Data, Device Identifier, Current Date and Time, Current
Sample Number.

# Procedure

The completion of this assignment took place across two main steps. The first of
these being the design and planning of the components required, and the second
being the implementation of this design.

## Design

The design of this assignment began with the design of the object class which
would be sent by the Client. This object must be able to store all of the
aforementioned data, including temperature, device ID, date and time, and sample
number. The temperature data can be read from the "/sys/class/thermal" directory
on the Raspberry Pi, or on a Linux PC for testing. 

The Client class is the next class to be designed, as it will transmit the
object data. The Client object must be able to connect to the server at the
IP address specified by the command line arguement used to initialise the
program. The object containing the temperature information must then be sent to
the Server, and a sampling frequency must be obtained from the server. The
client will wait for the specified amount of time before transmitting the next
object.

The next class to be designed following the Client is the Server class. The
Server class must start the GUI window, and then begin to listen for Client
connections. For this application, as the Server must be able to handle multiple
connections at once, it must implement a connection handler that utilises
multithreading. As such, when a Client connection is attained, the connection is
passed to a ThreadedConnectionHandler class, which will perform all necessary
operations and communications with the Client object.

The ThreadedConnectionHandler class is used to interact with the Client object
once it has connected to the Server. The Server object the Client's socket
information to the ThreadedConnectionHandler, which must then begins to listen
for input from the Client. Once a tramsmission is received from the Client, the
ThreadedConnectionHandler must store this object to an array, which will hold the
last 20 values passed from the Client. The ThreadedConnectionHandler must also
respond to the client with the selected sampling frequency, as chosen in the
GUI. Within this class, the GUI must also be updated to include the newly
received information.

The final class to be designed is the ServerGui. This class will be used to
display the graphed temperature and time information received from the Client,
and allow the user some control over the displayed information, and sampling
frequency. The ServerGUI will be initialised in the Server object constructor,
allowing it to run as soon as the Server program is started. The GUI must then
be updated from the ThreadedConnectionHandler objects in order to contain the
received information. The ServerGui will contain a number of JPanel, and
Graphics2D Swing components in order to correctly implement the graphing
functionality required.

## Implementation



# Results

## Testing Setup

Initial testing was completed using the development PC, a Ubuntu Linux system,
using the "TMUX" terminal multiplexer, and Eclipse. The ThrededServer was run
using either the Eclipse IDE or a TMUX terminal, while Clients were run in
multiple terminals within TMUX, as shown in Figure \ref{fig:tmuxsetup}. This
allowed for testing using the development PC's CPU temperature, and multiple
clients running within one easily readable window. 

\begin{figure}[H]
\includegraphics{images/tmuxsetup.png}
\centering
\caption{Testing Setup in TMUX using Two Clients}
\label{fig:tmuxsetup}
\end{figure}

## Initial CLI Testing

Initial testing within this setup yielded results which indicated that
the application was working as intended, with the console output showing the
stored temperature and device ID data. The output from this testing may be seen
in Figure \ref{fig:clitest}.

\begin{figure}[H]
\includegraphics{images/initclitest.png}
\centering
\caption{Initial Successful Command Line Test}
\label{fig:clitest}
\end{figure}

The Client classes main function, and the TempService constructor were modified
to take two command line arguements, the second of which is used to set the
thermal zone being read from, which allows for different readings to be achieved
from the same test machine. The results of this modification may be seen in
Figure \ref{fig:clitest2arg}.

\begin{figure}[H]
\includegraphics{images/clitest2arg.png}
\centering
\caption{Successful Command Line Test with Two Input Arguements}
\label{fig:clitest2arg}
\end{figure}

# Conclusion
