# Spring Bean的生命周期

![Bean的生命周期](https://images0.cnblogs.com/i/580631/201405/181453414212066.png)

## 启动Spring项目顺序

* 实例化BeanFactoryPostProcessor，并执行postProcessBeanFactory，`可以通过BeanFactoryPostProcessor提前实现注入对象属性`

* 实例化BeanPostProcessor，`用于初始化bean的回调`

* 实例化InstantiationAwareBeanPostProcessorAdapter，`用于实例化bean的回调`

* 开始注入每个bean，`注入过程，先执行InstantiationAwareBeanPostProcessor，在执行BeanPostProcessor`

## ⭐️注入一个bean的过程

* 执行InstantiationAwareBeanPostProcessor的postProcessBeforeInstantiation

* ——若构造函数中有传入对象，则先注入传入的bean

* 执行构造函数

* ——若属性有注入@Autowired的bean，则先注入属性中的bean

* ——若实现BeanNameAware接口，则调用BeanNameAware.setBeanName()

* ——若实现BeanFactoryAware接口，则调用BeanFactoryAware.setBeanFactory()

* 执行BeanPostProcessor的postProcessBeforeInitialization

* ——若有@PostConstruct注解的方法，则执行该方法

* ——若实现了InitializingBean接口，则调用InitializingBean.afterPropertiesSet()

* ——若通过@Bean指定了initMethod方法，则调用`<bean>`的init-method属性指定的初始化方法

* 执行BeanPostProcessor的postProcessAfterInitialization

* 执行InstantiationAwareBeanPostProcessor的postProcessAfterInstantiation

## Spring中bean的三种初始化方法：postConstruct、afterPropertiesSet、init-method：

* Spring在设置完一个bean所有的属性后，会检查bean是否实现了InitializingBean接口，如果实现就调用bean的afterPropertiesSet方法

* 如果一个bean同时实现了这两种方式的初始化配置,则spring会先调用afterPropertiesSet方法,然后通过反射调用init-method

* 通过@PostConstruct注解的方法在afterPropertiesSet和init-method方法之前调用

## InstantiationAwareBeanPostProcessor和BeanPostProcessor提供了注入每个bean时的两个回调：

* 在BeanPostProcessor接口的实现类中注入的bean，相当于`提前注入`，不会受该类的before/after的回调的影响

* InstantiationAwareBeanPostProcessor是BeanPostProcessor的子接口，可以在Bean生命周期的另外两个时期提供扩展的回调接口，即`实例化Bean`之前（调用postProcessBeforeInstantiation方法）和`实例化Bean`之后（调用postProcessAfterInstantiation方法

## 如果被装配的Bean实现了相应的接口，就可以在Bean中获得相应的信息：

* BeanNameAware：获得Bean名，也就是`<Bean>`标签的id属性值。  

* BeanClassLoaderAware：获得装载过程中的ClassLoader对象。  

* BeanFactoryAware：获得BeanFactory对象  

* ApplicationContextAware：获得ApplicationContext对象  

* InitializingBean：在Bean的所有属性设置完后，并且在调用完上面接口的方法后，调用此接口的afterPropertiesSet方法  

* DisposableBean：当销毁Bean时，调用此接口的destroy方法

参考文献：
http://www.cnblogs.com/zrtqsk/p/3735273.html