job(type: Maven) {
    name('MyMavenJob')
    goals('install')

    preBuildSteps {
        shell('#!/bin/bash\n' +
              'echo "PRE BUILD SCRIPT"\n' +
              'env | sort\n' +
              'echo "PRE BUILD END"\n')
    }
    
    postBuildSteps {
        shell('#!/bin/bash\n' +
              'echo "POST BUILD SCRIPT"\n' +
              'env | sort\n' +
              'echo "POST BUILD END"\n')
    }

    // Append <runPostStepsIfResult> at the end of the xml
    //    (which will be just after the closing </postbuilders> tag)
    // "it" is a groovy.util.Node representing the
    //    root <project> element of config.xml.
    configure { it <<
        'runPostStepsIfResult' {
            name('SUCCESS')
        }
    }
}
