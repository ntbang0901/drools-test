package com.example.rule.service;

import com.example.rule.model.Participant;
import com.example.rule.model.Rate;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

import org.drools.base.definitions.rule.impl.RuleImpl;
import org.drools.base.rule.RuleConditionElement;
import org.drools.template.model.Consequence;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.definition.KiePackage;
import org.kie.api.definition.rule.Rule;
import org.kie.api.io.Resource;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Service;

@Service
public class DroolsService {
    @Autowired
    private KieContainer kieContainer;

    public Rate getRate(Participant applicantRequest) {
        int nRules = 0;
        Collection<KiePackage> packages = kieContainer.getKieBase().getKiePackages();
        Rate rate = new Rate();
        KieSession kieSession = kieContainer.newKieSession();
        List<Rule> listRules = new ArrayList<>();
        for( KiePackage pack: packages ){
            listRules.addAll(pack.getRules());
        }
        kieSession.setGlobal("rate", rate);
        kieSession.insert(applicantRequest);
        kieSession.fireAllRules();
        kieSession.dispose();
        for (Rule rule : listRules) {
            RuleImpl ri = (RuleImpl) rule;
            System.out.println("L: " + ri.getLhs());
            System.out.println("Name: " + ri.getName());
            System.out.println("L2: " + ri.getLhs().getChildren().get(0).getNestedElements());
        }
        return rate;
    }

}
