document.addEventListener('DOMContentLoaded', function () {
    const policyTableBody = document.getElementById('policyTableBody');
    const policyDetailView = document.getElementById('policyDetailView');

    // Sample policy data
    let policies = [
        { id: 1, name: 'Health Insurance', type: 'Health', details: 'Covers health-related expenses' },
        { id: 2, name: 'Car Insurance', type: 'Vehicle', details: 'Covers vehicle damage and theft' },
    ];

    // Function to render policies in the table
    function renderPolicies() {
        policyTableBody.innerHTML = '';
        policies.forEach(policy => {
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${policy.id}</td>
                <td>${policy.name}</td>
                <td>${policy.type}</td>
                <td>${policy.details}</td>
                <td><button class="btn btn-info btn-sm" onclick="viewPolicy(${policy.id})">View</button></td>
            `;
            policyTableBody.appendChild(row);
        });
    }

    // Function to add a new policy
    document.getElementById('addPolicyForm').addEventListener('submit', function (event) {
        event.preventDefault();

        const name = document.getElementById('policyName').value;
        const type = document.getElementById('policyType').value;
        const details = document.getElementById('policyDetails').value;

        const newPolicy = {
            id: policies.length + 1,
            name: name,
            type: type,
            details: details
        };

        policies.push(newPolicy);
        renderPolicies();
        $('#addPolicyModal').modal('hide');
        this.reset();
    });

    // Function to view policy details
    window.viewPolicy = function (id) {
        const policy = policies.find(p => p.id === id);
        if (policy) {
            policyDetailView.innerHTML = `
                <h3>${policy.name}</h3>
                <p><strong>Type:</strong> ${policy.type}</p>
                <p><strong>Details:</strong> ${policy.details}</p>
            `;
            $('#policyDetails').tab('show');
        }
    };

    // Initial render of policies
    renderPolicies();
});
