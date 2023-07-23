# Uncertainty Java Library

Uncertainty is an inherent property of any measure or estimation performed in any physical setting, and therefore it needs to be considered when modeling systems that manage real data. Although several modeling languages permit the representation of measurement uncertainty for describing some system attributes, these aspects are not normally incorporated into their type systems. Thus, operating with uncertain values and propagating uncertainty are normally cumbersome processes, difficult to achieve at the model level. This library provides an extension of Python basic datatypes to incorporate data uncertainty coming from physical measurements or user estimations into the models, along with the set of operations defined for the values of these types.

This Java library supports an extension of the UML/OCL primitive datatypes with uncertainty, including ``UBoolean``, ``SBoolean``, ``UReal``, ``UInteger``, ``UnlimitedNatural``. This library of Java classes implements linear error propagation theory in Java.

Uncertain numerical values,  ``UReal`` and ``UInteger``, are represented by pairs ``(x,u)`` where ``x`` is the numerical (nominal) value and ``u`` is its associated uncertainty. For example, ``UReal(3.5,0.1)`` represents the uncertain real number 3.5 +/- 0.1, and ``UInteger(30,1)`` represents the uncertain integer 30 +/- 1. 

This representation of uncertainty for numerical values follows the "ISO Guide to Measurement Uncertainty" ([JCMG 100:2008](https://www.bipm.org/documents/20126/2071204/JCGM_100_2008_E.pdf)), where values are represented by the mean and standard deviation of the assumed probability density function representing how measurements of ground truth values are distributed. For example, if we assume that the values of a variable X follow a normal distribution N(x, σ), then we set u = σ. If we can only assume a uniform or rectangular distribution of the possible values of X, then x is taken as the midpoint of the interval, x = (a + b)/2, and its associated standard deviation as u = (b - a)/(2 * sqrt(3)).

Type ``UBoolean`` extends type ``Boolean`` by using propabilities instead of the traditional logical truth values (True, False), and by replacing truth tables by probability expressions. Thus, an ``UBoolean`` value is expressed by a probability representing the degree of belief (i.e., the *confidence*) that a given statement is true. For example, ``UBoolean(true,0.7)`` means that there is a 70% chance of an event occurring. Boolean values ``true`` and ``false`` correspond to ``UBoolean(true,1.0)`` and ``UBoolean(true, 0.0)``, respectively.  

Type ``SBoolean`` provides an extension of ``UBoolean`` to represent binomial *opinions* in [Subjective Logic](https://en.wikipedia.org/wiki/Subjective_logic). They allow expressing degrees of belief with epistemic uncertainty, and also trust. A binomial opinion about a given fact X by a belief agent A is represented as a quadruple ``SBoolean(b,d,u,a)`` where

- ``b`` is the degree of belief that X is True
- ``d`` is the degree of belief that X is False
- ``u`` is the amount of uncommitted belief, also interpreted as epistemic uncertainty.
- ``a`` is the prior probability in the absence of belief or disbelief.

These values are all real numbers in the range [0,1] and satisfy that *b+d+u=1*. The "*projected*" probability of a binomial opinion is defined as *P=b+au*. 

All related operations and Mathematical functions on these datatypes are supported. 

## Main features

This library provides a simple implementation of uncertainty for UML/OCL primitive datatypes, and implements linear error propagation theory in Java.
Our goal was to support the basic mechanisms for the expression and propagation of uncertainty, in a lightweight and efficient manner. 

A distinguishing feature of this library is that comparison operators return ``UBoolean`` values. This is not supported by the rest of the related uncertainty libraries, such as [uncertainties package](https://pythonhosted.org/uncertainties), [soerp](https://pypi.python.org/pypi/soerp) or [mcerp](https://pypi.python.org/pypi/mcerp).

Unlike in these other packages, correlations between expressions are not automatically taken into account in this library. This saves keeping track at all times of all correlations between quantities (variables and functions), improving the performance of the calculations. However, this implies that, ***by default, we assume that variables are independent***. Among other things, this means that users are expected to simplify numerical expressions as much as possible in order to avoid duplication of uncertain variables.

In any case, should there be a need to deal with dependent variables, ``UInteger`` and ``UReal`` mathematical operations allow specifying the correlation between them.

The derivatives of mathematical expressions are not automatically handled by this library. Again, this saves keeping track of the value of derivatives and automatically obtaining them, something that also impacts performance. Other unsuported features include automatic handling of arrays of uncertain numbers, or higher-order analysis to error propagation.

There are more powerful libraries that provide these features. 
 
 - For example, the [uncertainties package](https://pythonhosted.org/uncertainties) provides full support for uncertainty progagation, variable correlation, derivatives, and integration with the [NumPy](https://numpy.org/) package for scientific computation in Python. Most uncertainty calculations are performed analytically.
  
 - [soerp](https://pypi.python.org/pypi/soerp) is another uncertainty calculation package for Python that provides higher-order approximations of uncertainty. In particular, it supports a second-order analysis to error propagation. Advanced mathematical functions, similar to those in the standard [math](http://docs.python.org/library/math.html) module can also be evaluated directly.

-  [mcerp](https://pypi.python.org/pypi/mcerp) provides a stochastic calculator for Monte Carlo methods that uses 
latin-hypercube sampling to perform non-order specific 
error propagation (or uncertainty analysis).

The problem is that these implementations are sometimes too slow, e.g., when used in iterative methods, and their comparison operations are not expressive enough -- that is, the return *crisp* boolean values. This library tries to address these limitations.

In summary, the uncertain datatypes provided by this library is well suited for applications that require simple mechanisms for the propagation of uncertainty, efficient computation, and a closed algebra of datatypes (e.g., the comparison of two uncertain numeric values returns a probability, i.e., a ``UBoolean`` value).  


## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License

[MIT Licence](https://choosealicense.com/licenses/mit/)

Copyright (c) 2023 Atenea Research group.

*Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:*

*The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.*

## Version control

This is the first version of this Java library (September 2023).

---

## References and further information


The following papers contain all the details about these datatypes:

- Manuel F. Bertoa, Loli Burgueño, Nathalie Moreno, Antonio Vallecillo. "Incorporating measurement uncertainty into OCL/UML primitive datatypes" Softw. Syst. Model. 19(5):1163-1189, 2020. https://doi.org/10.1007/s10270-019-00741-0
- Paula Muñoz, Loli Burgueño, Victor Ortiz, Antonio Vallecillo. "Extending OCL with Subjective Logic" J. Object Technol. 19(3): 3:1-15, 2020. https://doi.org/10.5381/jot.2020.19.3.a1

Examples of applications of the uncertainty datatypes presented here can be found in the following papers:

- Jean-Marc Jézéquel, Antonio Vallecillo. "Uncertainty-aware Simulation of Adaptive Systems"  ACM Transactions on Modeling and Computer Simulation, 33(3):8:1-8:19, 2023. https://doi.org/10.1145/3589517

- Lola Burgueño, Paula Muñoz, Robert Clarisó, Jordi Cabot, Sébastien Gérard, Antonio Vallecillo. "Dealing with Belief Uncertainty in Domain Models" ACM Trans. Softw. Eng. Methodol. 32(2):31:1-31:34, 2023. https://doi.org/10.1145/3542947
- Francisco J. Navarrete, Antonio Vallecillo.
"Introducing Subjective Knowledge Graphs" In Proc. of EDOC 2021. pp. 61-70, 2021. https://doi.org/10.1109/EDOC52215.2021.00017
- 	Nathalie Moreno, Manuel F. Bertoa, Loli Burgueño, Antonio Vallecillo. "Managing Measurement and Occurrence Uncertainty in Complex Event Processing Systems" IEEE Access 7:88026-88048, 2019. https://doi.org/10.1109/ACCESS.2019.2923953
- Victor Ortiz, Loli Burgueño, Antonio Vallecillo, Martin Gogolla. "Native Support for UML and OCL Primitive Datatypes Enriched with Uncertainty in USE" In Proc. of OCL@MoDELS 2019:59-66, 2019. https://ceur-ws.org/Vol-2513/paper5.pdf 
- Nathalie Moreno, Manuel F. Bertoa, Gala Barquero, Loli Burgueño, Javier Troya, Adrián García-López, Antonio Vallecillo. "Managing Uncertain Complex Events in Web of Things Applications". In Proc. of ICWE 2018:349-357, 2018. https://doi.org/10.1007/978-3-319-91662-0_28
- Loli Burgueño, Manuel F. Bertoa, Nathalie Moreno, Antonio Vallecillo. "Expressing Confidence in Models and in Model Transformation Elements" In Proc. of MoDELS 2018: 57-66, 2018. https://doi.org/10.1145/3239372.3239394
 


For more information, please visit our research group's websites: 
- [Atenea Research Group](http://atenea.lcc.uma.es/) 
- [Atenea: Uncertain UML/OCL Types](http://atenea.lcc.uma.es/projects/UncertainOCLTypes.html) 
- [Atenea: Subjective Logic](http://atenea.lcc.uma.es/projects/SubjectiveLogic.html)


---